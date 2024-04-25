package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Entry;
import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import com.polytech.touristrootserver.exception.EntryNotFound;
import com.polytech.touristrootserver.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EntryServiceJpa implements EntryService{

    private final EntryRepository repository;
    private final TouristService touristService;

    private final NotificationEntryService notificationEntryService;

    @Override
    public List<Entry> findEntriesByTouristId(long id) {
        touristService.getTouristById(id);
        return repository.findEntriesByTouristId(id);
    }

    @Override
    public Entry insert(Entry entry) {
        return repository.save(entry);
    }

    @Override
    public Entry updateStatus(Entry entry) {
        Entry entryOld = repository.findById(entry.getId()).orElseThrow(() -> new EntryNotFound(
                "entry with id " + entry.getId() + " was not found"));
        entryOld.setStatus(entry.getStatus());
        return repository.save(entryOld);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
