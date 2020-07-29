package com.disastertracker.conflict;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conflicts")
public class ConflictController {

    private final ConflictRepository conflictRepo;
    private final CountryRepository countryRepo;

    public ConflictController(ConflictRepository conflictRepo, CountryRepository countryRepo) {
        this.conflictRepo = conflictRepo;
        this.countryRepo = countryRepo;
    }

    //Gets a list of all conflicts
    @GetMapping("")
    public Iterable<Conflict> allConflicts() {
        return this.conflictRepo.findAll();
    }

    //Gets a list of conflicts by location (i.e. Iraq, Egypt, Pakistan)
    @GetMapping("/location/{location}")
    public List<Conflict> conflictsByLocation(@PathVariable String location){
        return this.conflictRepo.findByLocation(location);
    }

    //Gets a list of all conflicts by region
    @GetMapping("/region/{region}")
    public List<Conflict> conflictsByRegion(@PathVariable String region){
        List<Country> countries = this.countryRepo.findByRegion(region);        //List of all countries in the region
        List<Conflict> conflicts = (List<Conflict>) this.conflictRepo.findAll();    //List of all conflicts
        List<Conflict> conflictsByRegion = new ArrayList<>();
        for (Conflict conflict : conflicts) {
            String location = conflict.getLocation();
            for (Country country: countries) {
                String countryName = country.getCountry();
                if(location.equals(countryName)){
                    conflictsByRegion.add(conflict);
                }
            }
        }
        return conflictsByRegion;
    }

    //Gets a conflict by ID
    @GetMapping("/id/{id}")
    public Conflict conflictById(@PathVariable Long id){
        return this.conflictRepo.findById(id).orElseThrow();
    }

    //Gets a list of conflicts by status
    @GetMapping("/status/{status}")
    public List<Conflict> conflictByStatus(@PathVariable String status){
        return this.conflictRepo.findByStatus(status);
    }

    //Gets a conflict by name
    @GetMapping("/name/{name}")
    public Conflict conflictByName(@PathVariable String name){
        return this.conflictRepo.findByName(name);
    }

    //Gets a list of all countries
    @GetMapping("/countries")
    public Iterable<Country> allCountries() {
        return this.countryRepo.findAll();
    }

    //Posts a new conflict - I will cut you if you use this
    @PostMapping("")
    public Conflict createConflict(@RequestBody Conflict conflict) {
        return this.conflictRepo.save(conflict);
    }

    //Posts a new country - I will cut you if you use this
    @PostMapping("/countries")
    public Country createCountry(@RequestBody Country country) {
        return this.countryRepo.save(country);
    }
}
