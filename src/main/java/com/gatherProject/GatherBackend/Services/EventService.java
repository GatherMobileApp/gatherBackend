package com.gatherProject.GatherBackend.Services;


import com.gatherProject.GatherBackend.Models.Event;

import java.util.concurrent.ExecutionException;

public interface EventService {

    String COL_NAME="events";

    Event createEvent(Event event) throws InterruptedException, ExecutionException;

    Event getEvent(String eventId) throws InterruptedException, ExecutionException;

    Event updateEvent(Event event) throws InterruptedException, ExecutionException;

    void deleteEvent(String eventId) throws InterruptedException, ExecutionException;




}
