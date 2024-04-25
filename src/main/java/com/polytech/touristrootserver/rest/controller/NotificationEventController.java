package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.rest.dto.NotificationEntryDtoForOrganization;
import com.polytech.touristrootserver.rest.dto.NotificationEntryDtoForTourist;
import com.polytech.touristrootserver.rest.dto.TouristDto;
import com.polytech.touristrootserver.service.NotificationEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationEventController {
    private final NotificationEntryService service;
    @GetMapping("/notification-entry/tourist/{id}")
    public List<NotificationEntryDtoForTourist> getByTouristId(@PathVariable(name = "id") long id) {
        return service.getByTouristId(id).stream().map(NotificationEntryDtoForTourist::toDto).toList();
    }

    @GetMapping("/notification-entry/organization/{id}")
    public List<NotificationEntryDtoForOrganization> getByOrganizationId(@PathVariable(name = "id") long id) {
        return service.getByOrganizationId(id).stream().map(NotificationEntryDtoForOrganization::toDto).toList();
    }
    @PostMapping("/notification-entry/insert")
    public NotificationEntry insert(@RequestBody NotificationEntryDtoForOrganization notificationEntry) {
        return service.insert(NotificationEntryDtoForOrganization.fromDto(notificationEntry));
    }
}
