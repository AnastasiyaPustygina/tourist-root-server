package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.Entry;
import com.polytech.touristrootserver.domain.Event;
import com.polytech.touristrootserver.domain.Tourist;
import com.polytech.touristrootserver.domain.enums.StatusEntry;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class EntryDto {

    private long id;
    private StatusEntry status;
    private EventDto eventDto;

    public static EntryDto toDto(Entry entry){
        return EntryDto.builder().id(entry.getId()).status(entry.getStatus()).eventDto(EventDto.toDto(entry.getEvent())).build();
    }
    public static Entry fromDto(EntryDto entry){
        return Entry.builder().id(entry.getId()).status(entry.getStatus()).event(EventDto.fromDto(entry.getEventDto())).build();
    }
}
