package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.ChatRoom;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{

    @Override
    public ChatRoom persistChatRoom(ChatRoom chatRoom) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(chatRoom.getChatRoomId()).set(chatRoom);
        return getChatRoom(chatRoom.getChatRoomId());
    }

    @Override
    public ChatRoom getChatRoom(String chatRoomId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(chatRoomId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(ChatRoom.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteChatRoom(String chatRoomId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(chatRoomId).delete();
    }
}
