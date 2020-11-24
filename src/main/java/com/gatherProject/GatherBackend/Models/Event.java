package com.gatherProject.GatherBackend.Models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;


public class Event {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String eventId;
    private String name;
    private Date date;
    private String location;
    private String description;

    private Ministry username;

    public Event(String eventId, String name, Date date, String location, String description, Ministry username) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.username = username;
    }

    public Event() {
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Ministry getUserId() {
        return username;
    }

    public void setUserId(Ministry username) { this.username = username; }

}
