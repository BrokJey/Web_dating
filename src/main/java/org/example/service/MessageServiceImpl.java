package org.example.service;

import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendMessage(Long senderId, Long receiverId, String text) {
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setContent(text);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages(Long userId1, Long userId2) {
        return messageRepository.findByUsers(userId1, userId2);
    }
}
