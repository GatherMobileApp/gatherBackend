package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/events")
public class EventController {
    final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> readEvent(@PathVariable String id) throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent(id);

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(event);
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(eventService.updateEvent(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable String id) throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent(id);

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        eventService.deleteEvent(id);

        return ResponseEntity.ok(event);
    }
}
