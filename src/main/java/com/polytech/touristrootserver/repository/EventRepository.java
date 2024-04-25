package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByOrderByDateStart();

    List<Event> findFirst10ByOrderByDateStart();

    @Query("SELECT e FROM Event e WHERE e.dateStart > :dateStart AND e.dateEnd < :dateEnd AND e.cost BETWEEN :minPrice" +
            " AND :maxPrice AND (e.dateEnd - e.dateStart) BETWEEN :minDuration AND :maxDuration AND e.category IN :categories")
    List<Event> findEventsByCriteria(@Param("dateStart") Timestamp dateStart, @Param("dateEnd") Timestamp dateEnd,
                                     @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice,
                                     @Param("minDuration") Duration minDuration, @Param("maxDuration") Duration maxDuration,
                                     @Param("categories") List<String> categories);
}
