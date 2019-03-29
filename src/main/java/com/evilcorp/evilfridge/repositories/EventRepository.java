package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
