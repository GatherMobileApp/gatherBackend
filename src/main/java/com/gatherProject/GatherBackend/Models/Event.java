package com.gatherProject.GatherBackend.Models;

import java.util.Date;

public class Event {

    private String eventId;
    private String name;
    private Date date;
    private String location;
    private String description;

    private Ministry ministry;

    public Event(String name, Date date, String location, String description, Ministry ministry) {
        this();
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.ministry = ministry;
    }

    public Event() {
        super();
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

    public Ministry getMinistry() {
        return ministry;
    }

    public void setMinistry(Ministry ministry) { this.ministry = ministry; }
}
