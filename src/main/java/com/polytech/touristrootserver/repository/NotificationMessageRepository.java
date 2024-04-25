package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.domain.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationMessageRepository extends JpaRepository<NotificationMessage, Long> {

    List<NotificationMessage> findByTouristId(long id);
    List<NotificationMessage> findByOrganizationId(long id);
}
