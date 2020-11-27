package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Models.Ministry;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EventServiceTest {
    final EventService eventService;
    static String eventId;

    @Autowired
    EventServiceTest(EventService eventService) {
        this.eventService = eventService;
    }

    @Test
    @Order(1)
    void createEvent() throws ExecutionException, InterruptedException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020, Calendar.NOVEMBER, 16, 18, 0);

        Ministry ministry = new Ministry("unitedcalvary", "a1b2c3d4", "me@home.org", "", "At Calvary United Methodist Church, from the first time you join us in person or in one of our online experiences, you will discover a warm welcome from a congregation of people committed to making disciples of Jesus Christ for the transformation of the world.",
                "1234 N Main St",  "25", "Methodist", "", new ArrayList<>(), "", "", "", "");


        Event event = new Event("Women's Bible Study", new Date(calendar.getTimeInMillis()), "Brownsburg, IN", "", ministry);
        event = eventService.createEvent(event);
        eventId = event.getEventId();
        Event newEvent = eventService.getEvent(eventId);

        Assertions.assertEquals(event.getName(), newEvent.getName());
    }

    @Test
    @Order(2)
    void readEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent(eventId);

        Assertions.assertEquals("Women's Bible Study", event.getName());
    }

    @Test
    @Order(3)
    void updateEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent(eventId);
        event.setName("Men's Bible Study");
        eventService.updateEvent(event);
        Event newEvent = eventService.getEvent(eventId);

        Assertions.assertEquals("Men's Bible Study", newEvent.getName());
    }

    @Test
    @Order(4)
    void deleteEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent(eventId);
        eventService.deleteEvent(event.getEventId());
        Event newEvent = eventService.getEvent(eventId);

        Assertions.assertNull(newEvent);
    }
}