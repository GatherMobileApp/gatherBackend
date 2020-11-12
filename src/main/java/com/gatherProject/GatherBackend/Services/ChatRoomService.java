package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.ChatRoom;

import java.util.concurrent.ExecutionException;

public interface ChatRoomService {

    public static final String COL_NAME="chatRooms";

//  ChatRoom model properties are named according to the schema on github under Docs/ModelAttributes.png

    public ChatRoom persistChatRoom(ChatRoom chatRoom) throws InterruptedException, ExecutionException;

    public ChatRoom getChatRoom(String chatRoomId) throws InterruptedException, ExecutionException;

    public void deleteChatRoom(String chatRoomId) throws InterruptedException, ExecutionException;
}
