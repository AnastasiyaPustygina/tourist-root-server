package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.domain.enums.Category;
import com.polytech.touristrootserver.exception.EntryNotFound;
import com.polytech.touristrootserver.rest.dto.EntryDto;
import com.polytech.touristrootserver.rest.dto.EventDto;
import com.polytech.touristrootserver.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public List<EventDto> getAll() {
        return eventService.findAllByOrderByDateStart().stream().map(EventDto::toDto).toList();
    }
    @GetMapping("/events/filter")
    public List<EventDto> getAllByCriteria(@RequestParam String dateStart,@RequestParam String dateEnd,
                                 @RequestParam double minPrice,@RequestParam double maxPrice,
                                 @RequestParam int minDuration, @RequestParam int maxDuration,
                                 @RequestParam List<Category> categories) {
        return eventService.findEventsByCriteria(Timestamp.valueOf(dateStart), Timestamp.valueOf(dateEnd), minPrice,
                        maxPrice, minDuration, maxDuration, categories)
                .stream().map(EventDto::toDto).toList();
    }

    @PostMapping("/event/insert")
    public EventDto insert(@RequestBody EventDto eventDto) {
        return EventDto.toDto(eventService.insert(EventDto.fromDto(eventDto)));
    }

    @PutMapping("/event/update")
    public EventDto update(@RequestBody EventDto eventDto) {
        return EventDto.toDto(eventService.update(EventDto.fromDto(eventDto)));
    }

    @DeleteMapping("/event/delete/{id}")
    public void deleteById(@PathVariable(name = "id") long id) {
        eventService.deleteById(id);
    }

}
