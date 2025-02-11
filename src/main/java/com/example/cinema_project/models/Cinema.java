package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "cinemas")
public class Cinema {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        
        @Column
        private String branch;

        @Column
        private double revenue;

        @ManyToMany
        @JoinTable(
            name = "cinemas_movies",
            joinColumns = {@JoinColumn(name = "cinema_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "movie_id", nullable = false)}
        )
        @JsonIgnoreProperties({"cinemas","screenings"})
        private List<Movie> movies;
        @OneToMany(mappedBy = "cinema")
        @JsonIgnoreProperties({"cinema","screenings"})
        private List<Screen> screens;

    public Cinema(String branch) {
        this.branch = branch;
        this.revenue = 0;
        this.movies = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public Cinema() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
