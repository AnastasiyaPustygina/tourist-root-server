package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationEntryDtoForOrganization {
    private long id;
    private NotificationStatus status;
    private EntryDto entryDto;
    private TouristDto touristDto;

    public static NotificationEntryDtoForOrganization toDto(NotificationEntry notificationEntry){
        return NotificationEntryDtoForOrganization.builder().id(notificationEntry.getId()).status(notificationEntry.getStatus())
                .entryDto(EntryDto.toDto(notificationEntry.getEntry())).touristDto(TouristDto.toDto(
                        notificationEntry.getTourist())).build();
    }
    public static NotificationEntry fromDto(NotificationEntryDtoForOrganization notificationEntryDto){
        return NotificationEntry.builder().id(notificationEntryDto.getId()).status(notificationEntryDto.getStatus())
                .tourist(TouristDto.fromDto(notificationEntryDto.getTouristDto()))
                .entry(EntryDto.fromDto(notificationEntryDto.getEntryDto())).build();
    }

}
