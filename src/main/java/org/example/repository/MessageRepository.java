package org.example.repository;

import org.example.model.Message;

import java.util.List;

public interface MessageRepository {
    void save(Message message);
    List<Message> findByUsers(Long senderId, Long receiverId);
}
