package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.NotificationMessage;
import com.polytech.touristrootserver.repository.NotificationMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationMessageJpa implements NotificationMessageService{

    private final NotificationMessageRepository repository;

    @Override
    public NotificationMessage insert(NotificationMessage notificationMessage) {
        return repository.save(notificationMessage);
    }

    @Override
    public List<NotificationMessage> getByTouristId(long id) {
        return repository.findByTouristId(id);
    }

    @Override
    public List<NotificationMessage> getByOrganizationId(long id) {
        return repository.findByOrganizationId(id);
    }
}
