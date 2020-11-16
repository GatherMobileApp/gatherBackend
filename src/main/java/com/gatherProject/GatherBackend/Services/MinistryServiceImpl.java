package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Ministry;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MinistryServiceImpl implements MinistryService{
    @Override
    public Ministry persistMinistry(Ministry ministry) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(ministry.getUsername()).set(ministry);
        return getMinistry(ministry.getUsername());
    }

    @Override
    public Ministry getMinistry(String username) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(username);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Ministry.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteMinistry(String username) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(username).delete();
    }
}
