package com.springboot.Application.services;

import org.springframework.stereotype.Service;

import com.springboot.Application.repositories.MessageRepository;

@Service ("messageService")
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public String obterMensagem() {
        return messageRepository.obterMensagem();
    }
}
