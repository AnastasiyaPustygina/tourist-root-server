package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.repository.NotificationEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationEntryServiceJpa implements NotificationEntryService{

    private final NotificationEntryRepository repository;

    @Override
    public NotificationEntry insert(NotificationEntry notificationEntry) {
        return repository.save(notificationEntry);
    }

    @Override
    public List<NotificationEntry> getByTouristId(long id) {
        return repository.findByTouristId(id);
    }

    @Override
    public List<NotificationEntry> getByOrganizationId(long id) {
        return repository.findByEntryEventOrganizationId(id);
    }
}
