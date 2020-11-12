package com.gatherProject.GatherBackend.Models;

import javax.persistence.Id;
import java.util.Date;

public class Message {
    @Id
    private String messageId;
    private ChatRoom chatRoom;
    private User senderName;
    private User receiverName;
    private String content;
    private Date timestamp;

}
