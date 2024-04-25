package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.Chat;
import com.polytech.touristrootserver.domain.Message;
import com.polytech.touristrootserver.domain.Organization;
import com.polytech.touristrootserver.domain.Tourist;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatDto {
    private long id;

    private TouristDto touristDto;

    private OrganizationDto organizationDto;

    private List<MessageDto> messages;

    public static ChatDto toDto(Chat chat){
        return ChatDto.builder().id(chat.getId()).touristDto(TouristDto.toDto(chat.getTourist()))
                .organizationDto(OrganizationDto.toDto(chat.getOrganization()))
                .messages(chat.getMessages().stream().map(MessageDto::toDto).toList()).build();
    }

    public static Chat fromDto(ChatDto chatDto){
        return Chat.builder().id(chatDto.getId()).tourist(TouristDto.fromDto(chatDto.getTouristDto()))
                .organization(OrganizationDto.fromDto(chatDto.getOrganizationDto()))
                .messages(chatDto.getMessages().stream().map(MessageDto::fromDto).toList()).build();
    }
}
