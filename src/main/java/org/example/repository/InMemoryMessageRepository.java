package org.example.repository;

import org.example.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryMessageRepository implements MessageRepository {
    private final List<Message> messages = new ArrayList<>();

    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> findByUsers(Long senderId, Long receiverId) {
        return messages.stream()
                .filter(m -> (m.getSenderId().equals(senderId) && m.getReceiverId().equals(receiverId)) ||
                        (m.getSenderId().equals(receiverId) && m.getReceiverId().equals(senderId)))
                .collect(Collectors.toList());
    }
}
