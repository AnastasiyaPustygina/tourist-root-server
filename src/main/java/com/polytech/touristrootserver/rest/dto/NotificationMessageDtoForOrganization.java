package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.NotificationMessage;
import com.polytech.touristrootserver.domain.Organization;
import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationMessageDtoForOrganization {
    private long id;
    private NotificationStatus status;
    private long chatId;
    private TouristDto touristDto;

    public static NotificationMessageDtoForOrganization toDto(NotificationMessage notificationMessage){
        return NotificationMessageDtoForOrganization.builder().id(notificationMessage.getId()).status(notificationMessage.getStatus())
                .touristDto(TouristDto.toDto(notificationMessage.getTourist()))
                .chatId(notificationMessage.getChatId()).build();
    }
    public static NotificationMessage fromDto(NotificationMessageDtoForOrganization notificationMessageDto){
        return NotificationMessage.builder().id(notificationMessageDto.getId()).status(notificationMessageDto.getStatus())
                .chatId(notificationMessageDto.getChatId()).tourist(TouristDto.fromDto(notificationMessageDto.getTouristDto())).build();
    }
}
