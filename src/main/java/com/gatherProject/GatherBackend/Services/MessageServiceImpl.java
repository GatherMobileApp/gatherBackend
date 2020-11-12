package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Message;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class MessageServiceImpl implements MessageService{
    @Override
    public Message saveMessage(Message message) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(message.getMessageId()).set(message);
        return getMessage(message.getMessageId());
    }

    @Override
    public Message getMessage(String messageId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(messageId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(Message.class);
        }else {
            return null;
        }
    }
}
