package com.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class FinishingTest {

    @Test(priority = 1)
    public void testFinishingStatus() {
        given().
        when().
        get("http://ergast.com/api/f1/status").
        then().
        log().all().
        assertThat().
        body("MRData.StatusTable.Status[0].statusId", notNullValue()).
        body("MRData.StatusTable.Status[0].status", notNullValue());
    }

    @Test(priority = 2)
    public void testLapTimesForSpecificRace() {
        given().
        when().
        get("http://ergast.com/api/f1/2011/5/laps/1").
        then().
        log().all().
        assertThat().
        body("MRData.RaceTable.Races[0].Laps[0].timing.driverId", notNullValue()).
        body("MRData.RaceTable.Races[0].Laps[0].timing.time", notNullValue());
    }

    @Test(priority = 3)
    public void testPitStopsForSpecificRace() {
        given().
        when().
        get("http://ergast.com/api/f1/2011/5/pitstops").
        then().
        log().all().
        assertThat().
        body("MRData.RaceTable.Races[0].PitStops[0].driverId", notNullValue()).
        body("MRData.RaceTable.Races[0].PitStops[0].lap", notNullValue()).
        body("MRData.RaceTable.Races[0].PitStops[0].time", notNullValue());
    }
}
