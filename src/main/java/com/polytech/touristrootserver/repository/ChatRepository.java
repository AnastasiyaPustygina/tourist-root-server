package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findByTouristIdAndOrganizationId(long touristId, long organizationId);

    List<Chat> getChatsByTouristId(long id);

    List<Chat> getChatsByOrganizationId(long id);

}
