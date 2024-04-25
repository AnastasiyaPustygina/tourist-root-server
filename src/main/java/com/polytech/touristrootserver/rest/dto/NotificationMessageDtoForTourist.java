package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.Message;
import com.polytech.touristrootserver.domain.NotificationMessage;
import com.polytech.touristrootserver.domain.Organization;
import com.polytech.touristrootserver.domain.Tourist;
import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationMessageDtoForTourist {
    private long id;
    private NotificationStatus status;
    private long chatId;
    private OrganizationDto organizationDto;

    public static NotificationMessageDtoForTourist toDto(NotificationMessage notificationMessage){
        return NotificationMessageDtoForTourist.builder().id(notificationMessage.getId()).status(notificationMessage.getStatus())
                .organizationDto(OrganizationDto.toDto(notificationMessage.getOrganization()))
                .chatId(notificationMessage.getChatId()).build();
    }
    public static NotificationMessage fromDto(NotificationMessageDtoForTourist notificationMessageDto){
        return NotificationMessage.builder().id(notificationMessageDto.getId()).status(notificationMessageDto.getStatus())
                .chatId(notificationMessageDto.getChatId()).organization(OrganizationDto.fromDto(
                        notificationMessageDto.getOrganizationDto())).build();
    }
}
