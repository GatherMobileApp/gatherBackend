package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.ChatRoom;
import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Models.Feature;
import com.gatherProject.GatherBackend.Models.Ministry;
import com.gatherProject.GatherBackend.Services.EventService;
import com.google.cloud.Timestamp;
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

    @Autowired
    EventServiceTest(EventService eventService) {
        this.eventService = eventService;
    }

    @Test
    @Order(1)
    void createEvent() throws ExecutionException, InterruptedException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020, 10, 16, 18, 00);

        Ministry ministry = new Ministry("unitedcalvary", "a1b2c3d4", "me@home.org", "", "At Calvary United Methodist Church, from the first time you join us in person or in one of our online experiences, you will discover a warm welcome from a congregation of people committed to making disciples of Jesus Christ for the transformation of the world.",
                "1234 N Main St",  25, "Methodist", "", new ArrayList<Feature>(), new ArrayList<ChatRoom>(), "", "", "", "");


        Event event = new Event("42", "Women's Bible Study", new Date(calendar.getTimeInMillis()), "Brownsburg, IN", "", ministry);
        eventService.persistEvent(event);
        Thread.sleep(5000);
        Event newEvent = eventService.getEvent("42");

        Assertions.assertEquals(event.getName(), newEvent.getName());
    }

    @Test
    @Order(2)
    void readEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent("42");

        Assertions.assertEquals("Women's Bible Study", event.getName());
    }

    @Test
    @Order(3)
    void updateEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent("42");
        event.setName("Men's Bible Study");
        eventService.persistEvent(event);
        Thread.sleep(5000);
        Event newEvent = eventService.getEvent("42");

        Assertions.assertEquals("Men's Bible Study", newEvent.getName());
    }

    @Test
    @Order(4)
    void deleteEvent() throws ExecutionException, InterruptedException {
        Event event = eventService.getEvent("42");
        eventService.deleteEvent(event.getEventId());
        Thread.sleep(5000);
        Event newEvent = eventService.getEvent("42");

        Assertions.assertNull(newEvent);
    }
}