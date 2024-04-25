package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.domain.NotificationMessage;

import java.util.List;

public interface NotificationMessageService {

    NotificationMessage insert(NotificationMessage notificationMessage);
    List<NotificationMessage> getByTouristId(long id);

    List<NotificationMessage> getByOrganizationId(long id);
}
