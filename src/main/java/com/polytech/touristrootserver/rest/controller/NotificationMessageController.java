package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.domain.NotificationMessage;
import com.polytech.touristrootserver.rest.dto.NotificationMessageDtoForOrganization;
import com.polytech.touristrootserver.rest.dto.NotificationMessageDtoForTourist;
import com.polytech.touristrootserver.service.NotificationMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationMessageController {
    private final NotificationMessageService service;
    @GetMapping("/notification-message/tourist/{id}")
    public List<NotificationMessageDtoForTourist> getByTouristId(@PathVariable(name = "id") long id) {
        return service.getByTouristId(id).stream().map(NotificationMessageDtoForTourist::toDto).toList();
    }

    @GetMapping("/notification-message/organization/{id}")
    public List<NotificationMessageDtoForOrganization> getByOrganizationId(@PathVariable(name = "id") long id) {
        return service.getByOrganizationId(id).stream().map(NotificationMessageDtoForOrganization::toDto).toList();
    }

    @PostMapping("/notification-message/insert")
    public NotificationMessage insert(@RequestBody NotificationMessage notificationMessage) {
        return  service.insert(notificationMessage);
    }
}
