package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class EventController {
    final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) throws ExecutionException, InterruptedException {
        return eventService.createEvent(event);
    }

    @GetMapping("/events/{id}")
    public Event readEvent(@PathVariable String id) throws ExecutionException, InterruptedException {
        return eventService.getEvent(id);
    }

    @PutMapping("/events")
    public Event updateEvent(@RequestBody Event event) throws ExecutionException, InterruptedException {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable String id) throws ExecutionException, InterruptedException {
        eventService.deleteEvent(id);
    }
}
