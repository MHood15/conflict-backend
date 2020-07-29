package com.disastertracker.conflict;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConflictRepository extends CrudRepository<Conflict, Long> {
    List<Conflict> findByLocation(String location);
    List<Conflict> findByStatus(String status);
    Conflict findByName(String name);
}
