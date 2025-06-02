package org.example.service;

import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class MessageServiceImplTest {
    @Test
    public void testSendAndReceiveMessage() {
        MessageRepository messageRepository = mock(MessageRepository.class);
        MessageServiceImpl service = new MessageServiceImpl(messageRepository);

        // Создаем тестовое сообщение
        Message testMessage = new Message();
        testMessage.setSenderId(1L);
        testMessage.setReceiverId(2L);
        testMessage.setContent("Hi there!");

        // Настраиваем мок
        when(messageRepository.findByUsers(1L, 2L)).thenReturn(List.of(testMessage));

        service.sendMessage(1L, 2L, "Hi there!");

        List<Message> history = service.getMessages(1L, 2L);
        assertEquals(1, history.size());
        assertEquals("Hi there!", history.get(0).getContent());
    }

}
