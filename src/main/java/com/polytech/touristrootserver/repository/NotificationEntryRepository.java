package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.NotificationEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationEntryRepository extends JpaRepository<NotificationEntry, Long> {
    List<NotificationEntry> findByTouristId(long id);
    List<NotificationEntry> findByEntryEventOrganizationId(long id);
}
