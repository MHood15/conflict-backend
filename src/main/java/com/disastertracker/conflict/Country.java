package com.disastertracker.conflict;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String region;
    @JsonBackReference
    @ManyToMany (mappedBy = "countries")
    private List<Conflict> conflicts;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public List<Conflict> getConflicts() { return conflicts; }
    public void setConflicts(List<Conflict> conflicts) { this.conflicts = conflicts; }

}
