package com.rest.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class RaceAPI {
	   @Test(priority = 1)
	    public void testCurrentSeasonRaceSchedule() {
	        given().
	        when().
	        get("http://ergast.com/api/f1/current.json").
	        then().
	        log().all().
	        assertThat().
	        body("MRData.RaceTable.Races", notNullValue()).
	        body("MRData.RaceTable.Races[0].season", equalTo("2024")). // Adjust this based on the current year
	        body("MRData.RaceTable.Races", hasSize(greaterThan(0)));
	    }

	    @Test(priority = 2)
	    public void testSpecificRaceSchedule() {
	        given().
	        when().
	        get("http://ergast.com/api/f1/2012/5.json").
	        then().
	        log().all().
	        assertThat().
	        body("MRData.RaceTable.Races[0].raceName", equalTo("Spanish Grand Prix")).
	        body("MRData.RaceTable.Races[0].Circuit.circuitId", equalTo("catalunya")).
	        body("MRData.RaceTable.Races[0].date", equalTo("2012-05-13"));
	    }

	    @Test(priority = 3)
	    public void testRaceResults() {
	        given().
	        when().
	        get("http://ergast.com/api/f1/2008/5/results.json").
	        then().
	        log().all().
	        assertThat().
	        body("MRData.RaceTable.Races[0].Results", notNullValue()).
	        body("MRData.RaceTable.Races[0].Results[0].driverId", equalTo("massa")).
	        body("MRData.RaceTable.Races[0].Results[0].position", equalTo("1"));
	    }

	    @Test(priority = 4)
	    public void testQualifyingResults() {
	        given().
	        when().
	        get("http://ergast.com/api/f1/2008/5/qualifying.json").
	        then().
	        log().all().
	        assertThat().
	        body("MRData.RaceTable.Races[0].QualifyingResults", notNullValue()).
	        body("MRData.RaceTable.Races[0].QualifyingResults[0].driverId", equalTo("massa")).
	        body("MRData.RaceTable.Races[0].QualifyingResults[0].position", equalTo("1"));
	    }
}
