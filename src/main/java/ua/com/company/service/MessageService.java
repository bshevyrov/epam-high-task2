package ua.com.company.service;


import ua.com.company.model.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    List<Message> getMessagesBySenderId(Long senderId);
    List<Message> getMessagesByReceiverId(Long receiverId);
    void deleteMessage(Long id);
}