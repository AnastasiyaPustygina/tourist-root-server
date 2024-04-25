package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Event;
import com.polytech.touristrootserver.domain.enums.Category;
import com.polytech.touristrootserver.repository.EventRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

@Data
@Service
public class EventServiceJpa implements EventService{

    private final EventRepository eventRepository;

    @Override
    public Event insert(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }
    @Override
    public List<Event> findAllByOrderByDateStart() {
        return eventRepository.findAllByOrderByDateStart();
    }

    @Override
    public List<Event> findEventsByCriteria(Timestamp dateStart, Timestamp dateEnd, double minPrice,
                                            double maxPrice, int minDuration, int maxDuration, List<Category> categories) {
        return eventRepository.findEventsByCriteria(dateStart, dateEnd, minPrice, maxPrice, Duration.ofDays(minDuration),
                Duration.ofDays(maxDuration),
                categories.stream().map(Enum::name).toList());
    }
    @Override
    public void deleteById(long id) {
        eventRepository.deleteById(id);
    }
}
