package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.NotificationEntry;

import java.util.List;

public interface NotificationEntryService {

    NotificationEntry insert(NotificationEntry notificationEntry);
    List<NotificationEntry> getByTouristId(long id);
    List<NotificationEntry> getByOrganizationId(long id);

}
