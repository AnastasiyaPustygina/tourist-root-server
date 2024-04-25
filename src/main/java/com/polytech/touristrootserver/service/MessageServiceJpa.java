package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Message;
import com.polytech.touristrootserver.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceJpa implements MessageService{

    private final MessageRepository messageRepository;

    @Override
    public Message insert(Message message) {
        return messageRepository.save(message);
    }
}
