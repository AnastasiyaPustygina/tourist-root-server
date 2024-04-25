package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.*;
import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationEntryDtoForTourist {
    private long id;
    private NotificationStatus status;
    private EntryDto entryDto;

    public static NotificationEntryDtoForTourist toDto(NotificationEntry notificationEntry){
        return NotificationEntryDtoForTourist.builder().id(notificationEntry.getId()).status(notificationEntry.getStatus())
                .entryDto(EntryDto.toDto(notificationEntry.getEntry())).build();
    }
    public static NotificationEntry fromDto(NotificationEntryDtoForTourist notificationEntryDto){
        return NotificationEntry.builder().id(notificationEntryDto.getId()).status(notificationEntryDto.getStatus())
                .entry(EntryDto.fromDto(notificationEntryDto.getEntryDto())).build();
    }

}
