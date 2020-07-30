package com.disastertracker.conflict;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conflicts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conflict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String background;
    private String dead;
    private String displaced;
    private String duration;
    private String status;      //(worsening, improving, unchanging)
    private String image;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "countries_involved",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countries;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getBackground() { return background; }
    public void setBackground(String background) { this.background = background; }

    public String getDead() { return dead; }
    public void setDead(String dead) { this.dead = dead; }

    public String getDisplaced() { return displaced; }
    public void setDisplaced(String displaced) { this.displaced = displaced; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public List<Country> getCountries() { return countries; }
    public void setCountries(List<Country> countries) { this.countries = countries; }

}
