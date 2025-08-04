package com.springboot.Application.repositories;

import org.springframework.stereotype.Repository;

@Repository("messageRepository")
public class MessageRepository {
    public String obterMensagem() {
        return "Olá do repositório";
    }
}
