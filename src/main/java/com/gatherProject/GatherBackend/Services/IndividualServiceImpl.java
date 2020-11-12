package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Individual;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class IndividualServiceImpl implements IndividualService{

    @Override
    public Individual persistIndividual(Individual individual) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(individual.getUsername()).set(individual);
        return getIndividual(individual.getUsername());
    }

    @Override
    public Individual getIndividual(String username) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(username);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Individual.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteIndividual(String username) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(username).delete();
    }
}
