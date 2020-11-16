package com.gatherProject.GatherBackend.Services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class Auth {
    private String idToken;
    FirebaseToken decodedToken;
    public void verifyIdToken() {
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
        String uid = decodedToken.getUid();
    }
}
