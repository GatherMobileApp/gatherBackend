package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.ChatRoom;
import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Models.Feature;
import com.gatherProject.GatherBackend.Models.Ministry;
import com.gatherProject.GatherBackend.Services.EventService;
import com.google.cloud.Timestamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class EventControllerTest {
    final EventService eventService;

    @Autowired
    EventControllerTest(EventService eventService) {
        this.eventService = eventService;
    }

    @Test
    void createEvent() throws ExecutionException, InterruptedException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020, 10, 16, 18, 00);

        Ministry ministry = new Ministry("unitedcalvary", "a1b2c3d4", "me@home.org", "", "At Calvary United Methodist Church, from the first time you join us in person or in one of our online experiences, you will discover a warm welcome from a congregation of people committed to making disciples of Jesus Christ for the transformation of the world.",
                "1234 N Main St",  25, "Methodis", "", new ArrayList<Feature>(), new ArrayList<ChatRoom>(), "", "", "", "");


        Event event = new Event(42L, "Women's Bible Study", Timestamp.of(calendar.getTime()), "Brownsburg, IN", "", ministry);

        Event newEvent = eventService.persistEvent(event);
        Assertions.assertEquals(event.getName(), newEvent.getName());
    }

    @Test
    void readEvent() {
    }

    @Test
    void updateEvent() {
    }

    @Test
    void deleteEvent() {
    }
}