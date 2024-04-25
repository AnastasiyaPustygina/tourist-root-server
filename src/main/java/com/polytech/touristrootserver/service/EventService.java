package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Event;
import com.polytech.touristrootserver.domain.enums.Category;

import java.sql.Timestamp;
import java.util.List;

public interface EventService {

    Event insert(Event event);

    Event update(Event event);

    List<Event> findAllByOrderByDateStart();

    List<Event> findEventsByCriteria(Timestamp dateStart, Timestamp dateEnd, double minPrice, double maxPrice,
                                     int minDuration, int maxDuration, List<Category> categories);
    void deleteById(long id);
}
