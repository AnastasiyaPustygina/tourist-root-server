package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long>{
    Optional<Tourist> findByEmail(String email);
}
