package org.example.controller;

import org.example.model.Message;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public void sendMessage(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam String content
    ) {
        messageService.sendMessage(senderId, receiverId, content);
    }

    @GetMapping
    public List<Message> getMessages(
            @RequestParam Long senderId,
            @RequestParam Long receiverId
    ) {
        return messageService.getMessages(senderId, receiverId);
    }
}