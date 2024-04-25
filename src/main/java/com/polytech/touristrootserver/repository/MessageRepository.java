package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Message;
import com.polytech.touristrootserver.domain.NotificationEntry;
import com.polytech.touristrootserver.domain.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<NotificationMessage> getByChatTouristId(long id);

    List<NotificationMessage> getByChatOrganizationId(long id);

}
