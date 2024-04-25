package com.polytech.touristrootserver.repository;

import com.polytech.touristrootserver.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {


    List<Entry> findEntriesByTouristId(long id);
}
