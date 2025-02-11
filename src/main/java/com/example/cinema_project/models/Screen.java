package com.example.cinema_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "capacity")
    private int capacity;

    @Column
    private int seatsInOneLine;
    
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnoreProperties({"screens","movies"})
    private  Cinema cinema;
    

    @OneToMany(mappedBy = "screen")
    @JsonIgnoreProperties({"screen","movie","bookings"})
    List<Screening> screenings;

    public Screen(int capacity, Cinema cinema, int seatsInOneLine) {
        this.capacity = capacity;
        this.screenings = new ArrayList<>();
        this.cinema = cinema;
        this.seatsInOneLine = seatsInOneLine;
    }

    public Screen(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getSeatsInOneLine() {
        return seatsInOneLine;
    }

    public void setSeatsInOneLine(int seatsInOneLine) {
        this.seatsInOneLine = seatsInOneLine;
    }
}