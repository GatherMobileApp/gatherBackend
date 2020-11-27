package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Event;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public Event createEvent(Event event) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document();
        event.setEventId(documentReference.getId());
        ApiFuture<WriteResult> future = documentReference.set(event);

        do {
            Thread.sleep(25);
        } while (! future.isDone());

        return event;
    }

    @Override
    public Event getEvent(String eventId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(eventId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Event.class);
        }else {
            return null;
        }
    }

    @Override
    public Event updateEvent(Event event) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(event.getEventId());
        ApiFuture<WriteResult> future = documentReference.set(event);

        do {
            Thread.sleep(25);
        } while (! future.isDone());

        return event;
    }

    @Override
    public void deleteEvent(String eventId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = dbFirestore.collection(COL_NAME).document(eventId).delete();

        do {
            Thread.sleep(25);
        } while (! future.isDone());
    }
}
