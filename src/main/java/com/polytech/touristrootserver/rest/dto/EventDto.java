package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.Entry;
import com.polytech.touristrootserver.domain.Event;
import com.polytech.touristrootserver.domain.Image;
import com.polytech.touristrootserver.domain.enums.Category;
import com.polytech.touristrootserver.domain.enums.StatusEvent;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class EventDto {
        private long id;
        private String name;
        private int cost;
        private int currentCount;
        private int maxCount;
        private String place;
        private Category category;
        private Timestamp dateStart;
        private Timestamp dateEnd;
        private String requirement;
        private String information;
        private StatusEvent status;
        private List<Image> images;
    public static EventDto toDto(Event event){
        return EventDto.builder().id(event.getId()).name(event.getName()).cost(event.getCost()).currentCount(event.getCurrentCount())
                .maxCount(event.getMaxCount()).place(event.getPlace()).category(event.getCategory()).dateStart(event.getDateStart())
                .dateEnd(event.getDateEnd()).requirement(event.getRequirement()).information(event.getInformation())
                .status(event.getStatus()).images(event.getImages()).build();
    }

        public static Event fromDto(EventDto event){
                return Event.builder().id(event.getId()).name(event.getName()).cost(event.getCost()).currentCount(event.getCurrentCount())
                        .maxCount(event.getMaxCount()).place(event.getPlace()).category(event.getCategory()).dateStart(event.getDateStart())
                        .dateEnd(event.getDateEnd()).requirement(event.getRequirement()).information(event.getInformation())
                        .status(event.getStatus()).images(event.getImages()).build();
        }
}
