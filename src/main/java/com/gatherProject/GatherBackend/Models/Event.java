package com.gatherProject.GatherBackend.Models;


import com.google.cloud.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Event {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String name;
    private Timestamp date;
    private String location;
    private String description;

    private Ministry username;

    public Event(Long eventId, String name, Timestamp date, String location, String description, Ministry username) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.username = username;
    }

    public Event() {}

    public Long getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ministry getUsername() {
        return username;
    }

    public void setUsername(Ministry username) {
        this.username = username;
    }
}
