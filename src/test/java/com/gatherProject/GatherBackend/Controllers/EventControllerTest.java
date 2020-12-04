package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.Event;
import com.gatherProject.GatherBackend.Models.Ministry;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EventControllerTest {

    @Test
    public void testEventController() {
        String eventId;

        Calendar calendar = new GregorianCalendar();
        calendar.set(2020, Calendar.NOVEMBER, 16, 18, 0);

        Ministry ministry = new Ministry("unitedcalvary", "a1b2c3d4", "me@home.org", "", "At Calvary United Methodist Church, from the first time you join us in person or in one of our online experiences, you will discover a warm welcome from a congregation of people committed to making disciples of Jesus Christ for the transformation of the world.",
                "1234 N Main St",  "25", "Methodist", "", null, null, "", "https://calvaryunited.org", "", "");


        Event event = new Event("Women's Bible Study", new Date(calendar.getTimeInMillis()), "Brownsburg, IN", "", ministry);


        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + System.getenv("API_KEY"))
                .body(event)
                .post("http://localhost:8080/api/events");
        event = response.as(Event.class);
        eventId = event.getEventId();

        response.then()
                .assertThat()
                .statusCode(200);

        RestAssured.given().header("Content-Type", "application/json")
                .get("http://localhost:8080/api/events/" + eventId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", CoreMatchers.is("Women's Bible Study"));

        event.setName("Men's Bible Study");

        RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + System.getenv("API_KEY"))
                .body(event)
                .put("http://localhost:8080/api/events")
                .then()
                .assertThat()
                .statusCode(200);

        RestAssured.given().header("Content-Type", "application/json")
                .get("http://localhost:8080/api/events/" + eventId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", CoreMatchers.is("Men's Bible Study"));

        RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + System.getenv("API_KEY"))
                .delete("http://localhost:8080/api/events/" + eventId)
                .then()
                .assertThat()
                .statusCode(200);

    }
}
