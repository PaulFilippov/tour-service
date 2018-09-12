package com.paul.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String location;
    private Long start_date;
    private Long end_date;
    private Integer count_limit;
    @OneToMany
    Set<Order> orders;

    public Tour() {
    }

    public Tour(String name, String description, String location, Long start_date, Long end_date, Integer count_limit) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.start_date = start_date;
        this.end_date = end_date;
        this.count_limit = count_limit;
        this.orders = new HashSet<>();
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getStart_date() {
        return start_date;
    }

    public void setStart_date(Long start_date) {
        this.start_date = start_date;
    }

    public Long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Long end_date) {
        this.end_date = end_date;
    }

    public Integer getCount_limit() {
        return count_limit;
    }

    public void setCount_limit(Integer count_limit) {
        this.count_limit = count_limit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(name, tour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}