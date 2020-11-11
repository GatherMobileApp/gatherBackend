package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Event;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class EventServiceImpl implements EventService {

    @Override
    public Event persistEvent(Event event) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(event.getEventId().toString());
        documentReference.set(event);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot documentSnapshot = future.get();

        if(documentSnapshot.exists()) {
            return documentSnapshot.toObject(Event.class);
        }else {
            return null;
        }

    }

    @Override
    public Event getEvent(Long eventId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(eventId.toString());
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Event.class);
        }else {
            return null;
        }
    }

    @Override
    public Event deleteEvent(Long eventId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(eventId.toString());
        documentReference.delete();
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Event.class);
        }else {
            return null;
        }
    }
}
