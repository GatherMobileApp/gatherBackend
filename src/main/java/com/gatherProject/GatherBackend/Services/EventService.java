package com.gatherProject.GatherBackend.Services;


import com.gatherProject.GatherBackend.Models.Event;

import java.util.concurrent.ExecutionException;

public interface EventService {

    public static final String COL_NAME="events";



    public Event persistEvent(Event event) throws InterruptedException, ExecutionException;

    public Event getEvent(Long eventId) throws InterruptedException, ExecutionException;

    public Event deleteEvent(Long eventId) throws InterruptedException, ExecutionException;




}
