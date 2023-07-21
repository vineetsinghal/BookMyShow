package com.myBookShow.Entity;
import java.util.ArrayList;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduledMovie> scheduledMovies = new ArrayList<>();

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<ScheduledMovie> getScheduledMovies() {
        return scheduledMovies;
    }

    public void setScheduledMovies(List<ScheduledMovie> scheduledMovies) {
        this.scheduledMovies = scheduledMovies;
    }

    
    public void addScheduledMovie(ScheduledMovie scheduledMovie) {
        this.scheduledMovies.add(scheduledMovie);
        scheduledMovie.setScreen(this);
    }

   
    public void removeScheduledMovie(ScheduledMovie scheduledMovie) {
        this.scheduledMovies.remove(scheduledMovie);
        scheduledMovie.setScreen(null);
    }
}