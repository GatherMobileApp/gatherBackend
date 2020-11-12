package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Individual;
import com.gatherProject.GatherBackend.Models.Message;

import java.util.concurrent.ExecutionException;

public interface MessageService {

    public static final String COL_NAME="messages";


    public Message saveMessage(Message message) throws InterruptedException, ExecutionException;

    public Message getMessage(String messageId) throws InterruptedException, ExecutionException;

}
