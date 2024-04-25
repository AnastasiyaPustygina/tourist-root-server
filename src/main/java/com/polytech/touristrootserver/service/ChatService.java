package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Chat;

import java.util.List;

public interface ChatService {

    Chat insert(Chat chat);

    Chat getChatById(long id);

    List<Chat> getChatsByTouristId(long id);

    List<Chat> getChatsByOrganizationId(long id);
}
