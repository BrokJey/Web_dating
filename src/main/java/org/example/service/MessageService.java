package org.example.service;

import org.example.model.Message;

import java.util.List;

public interface MessageService {
    void sendMessage(Long senderId, Long receiverId, String text);
    List<Message> getMessages(Long userId1, Long userId2);
}
