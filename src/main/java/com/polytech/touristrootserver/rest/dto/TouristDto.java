package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.*;
import com.polytech.touristrootserver.domain.enums.AgePeriod;
import com.polytech.touristrootserver.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TouristDto {
    private long id;
    private String name;
    private String email;
    private Gender gender;
    private AgePeriod agePeriod;
    private String information;
    private String password;

//    private List<NotificationEntryDtoForTourist> notificationEntries;
//    private List<NotificationMessageDtoForTourist> notificationMessages;
    private Image image;

    public static Tourist fromDto(TouristDto touristDto){
        return Tourist.builder().id(touristDto.getId()).name(touristDto.getName()).email(touristDto.getEmail())
                .gender(touristDto.getGender()).agePeriod(touristDto.getAgePeriod()).information(touristDto.getInformation())
                .password(touristDto.getPassword())
//                .notificationEntries(touristDto.getNotificationEntries().stream().map(NotificationEntryDtoForTourist::fromDto).toList())
//                .notificationMessages(touristDto.getNotificationMessages().stream().map(NotificationMessageDtoForTourist::fromDto).toList())
                .image(touristDto.getImage()).build();
    }
    public static TouristDto toDto(Tourist tourist){
        return TouristDto.builder().id(tourist.getId()).name(tourist.getName()).email(tourist.getEmail())
                .gender(tourist.getGender()).agePeriod(tourist.getAgePeriod()).information(tourist.getInformation())
//                .password("").notificationEntries(tourist.getNotificationEntries().stream().map(NotificationEntryDtoForTourist::toDto).toList())
//                .notificationMessages(tourist.getNotificationMessages().stream().map(NotificationMessageDtoForTourist::toDto).toList())
                .image(tourist.getImage()).build();
    }
}
