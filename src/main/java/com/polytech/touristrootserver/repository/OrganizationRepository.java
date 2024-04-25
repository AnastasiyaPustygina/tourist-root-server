package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByManagerLoginAndManagerPassword(String login, String password);
}
