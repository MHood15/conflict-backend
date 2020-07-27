package com.disastertracker.conflict;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByRegion(String region);
    Long findByCountry(String country);
}
