package com.polytech.touristrootserver.service;


import com.polytech.touristrootserver.domain.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> findEntriesByTouristId(long id);

    Entry insert(Entry entry);

    Entry updateStatus(Entry entry);

    void deleteById(long id);
}
