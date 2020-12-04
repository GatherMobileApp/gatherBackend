/*
 * Copyright 2019 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Ported from PostreSQL to Firestore */
package com.gatherProject.GatherBackend.Authentication;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.concurrent.ExecutionException;

/**
 * Handles authenticating api keys against the database.
 */
public class ApiKeyAuthManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException  {
        String principal = (String) authentication.getPrincipal();

        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("apikeys").document(principal.substring(7));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot;

        try {
            documentSnapshot = future.get();
        } catch (InterruptedException|ExecutionException e) {
            BadCredentialsException badCredentialsException = new BadCredentialsException(e.getMessage());
            badCredentialsException.setStackTrace(e.getStackTrace());
            throw badCredentialsException;
        }

        if (! documentSnapshot.exists()) {
            throw new BadCredentialsException("The API key was not found or not the expected value.");
        } else {
            authentication.setAuthenticated(true);
            return authentication;
        }
    }
}
