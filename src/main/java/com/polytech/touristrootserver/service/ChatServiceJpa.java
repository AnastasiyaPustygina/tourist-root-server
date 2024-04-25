package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Chat;
import com.polytech.touristrootserver.exception.ChatNotFoundException;
import com.polytech.touristrootserver.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatServiceJpa implements ChatService{

    private final ChatRepository chatRepository;

    @Override
    public Chat insert(Chat chat) {
        Optional<Chat> existsChat = chatRepository.findByTouristIdAndOrganizationId(chat.getTourist().getId(),
                chat.getOrganization().getId());
        return existsChat.orElseGet(() -> chatRepository.save(chat));
    }

    @Override
    public Chat getChatById(long id) {
        return chatRepository.findById(id).orElseThrow(() -> new ChatNotFoundException("chat with id " + id + " was not found"));
    }

    @Override
    public List<Chat> getChatsByTouristId(long id) {
        return chatRepository.getChatsByTouristId(id);
    }

    @Override
    public List<Chat> getChatsByOrganizationId(long id) {
        return chatRepository.getChatsByOrganizationId(id);
    }
}
