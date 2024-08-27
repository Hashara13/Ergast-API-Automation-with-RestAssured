package com.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Standing {

    @Test(priority = 1)
    public void testSprintQualifyingResults() {
        given().
        when().
        get("http://ergast.com/api/f1/2021/10/sprint.json").
        then().
        log().all().
        assertThat().
        body("MRData.RaceTable.Races[0].SprintResults", notNullValue()).
        body("MRData.RaceTable.Races[0].SprintResults[0].driverId", equalTo("verstappen")).
        body("MRData.RaceTable.Races[0].SprintResults[0].position", equalTo("1"));
    }

    @Test(priority = 2)
    public void testDriverStandingsAfterSpecificRace() {
        given().
        when().
        get("http://ergast.com/api/f1/2008/5/driverStandings.json").
        then().
        log().all().
        assertThat().
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings", notNullValue()).
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings[0].driverId", equalTo("hamilton")).
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings[0].position", equalTo("1"));
    }

    @Test(priority = 3)
    public void testConstructorStandingsAfterSpecificRace() {
        given().
        when().
        get("http://ergast.com/api/f1/2008/5/constructorStandings.json").
        then().
        log().all().
        assertThat().
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings", notNullValue()).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].constructorId", equalTo("ferrari")).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].position", equalTo("1"));
    }

    @Test(priority = 4)
    public void testDriverStandingsEndOfSeason() {
        given().
        when().
        get("http://ergast.com/api/f1/2008/driverStandings.json").
        then().
        log().all().
        assertThat().
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings", notNullValue()).
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings[0].driverId", equalTo("hamilton")).
        body("MRData.StandingsTable.StandingsLists[0].DriverStandings[0].position", equalTo("1"));
    }

    @Test(priority = 5)
    public void testConstructorStandingsEndOfSeason() {
        given().
        when().
        get("http://ergast.com/api/f1/2008/constructorStandings.json").
        then().
        log().all().
        assertThat().
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings", notNullValue()).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].constructorId", equalTo("ferrari")).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].position", equalTo("1"));
    }

    @Test(priority = 6)
    public void testAllConstructorChampions() {
        given().
        when().
        get("http://ergast.com/api/f1/constructorStandings/1.json").
        then().
        log().all().
        assertThat().
        body("MRData.StandingsTable.StandingsLists", notNullValue()).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].position", equalTo("1")).
        body("MRData.StandingsTable.StandingsLists[0].ConstructorStandings[0].constructorId", equalTo("ferrari"));
    }

    @Test(priority = 7)
    public void testSpecificConstructorInfo() {
        given().
        when().
        get("http://ergast.com/api/f1/constructors/mclaren.json").
        then().
        log().all().
        assertThat().
        body("MRData.ConstructorTable.Constructors[0].constructorId", equalTo("mclaren")).
        body("MRData.ConstructorTable.Constructors[0].name", equalTo("McLaren")).
        body("MRData.ConstructorTable.Constructors[0].nationality", equalTo("British"));
    }

    @Test(priority = 8)
    public void testConstructorsForSpecificYear() {
        given().
        when().
        get("http://ergast.com/api/f1/2010/constructors.json").
        then().
        log().all().
        assertThat().
        body("MRData.ConstructorTable.Constructors", notNullValue()).
        body("MRData.ConstructorTable.Constructors", hasSize(greaterThan(0))).
        body("MRData.ConstructorTable.Constructors[0].constructorId", notNullValue());
    }

    @Test(priority = 9)
    public void testAllConstructors() {
        given().
        when().
        get("http://ergast.com/api/f1/constructors.json").
        then().
        log().all().
        assertThat().
        body("MRData.ConstructorTable.Constructors", notNullValue()).
        body("MRData.ConstructorTable.Constructors", hasSize(greaterThan(0))).
        body("MRData.ConstructorTable.Constructors[0].constructorId", notNullValue());
    }
}
