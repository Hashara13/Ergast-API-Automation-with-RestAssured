package com.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetCallBDD {
	 @Test(priority = 1)
    public void testCircuits() {
        given().
        when().
        get("http://ergast.com/api/f1/2015/circuits.json").
        then().
        log().all().  
        assertThat().
        body("MRData.CircuitTable.Circuits.circuitId", notNullValue()). 
        body("MRData.CircuitTable.Circuits.circuitId", hasSize(19)).and()
        .header("current-length", equalTo("4351")); 
    }
    
    @Test(priority = 2)
    public void testDriverData() {
        given().
        when().
        get("http://ergast.com/api/f1/drivers/alonso.json").
        then().
        log().all().  
        assertThat().
        body("MRData.DriverTable.Drivers[0].driverId", equalTo("alonso")).  
        body("MRData.DriverTable.Drivers[0].givenName", equalTo("Fernando")).  
        body("MRData.DriverTable.Drivers[0].familyName", equalTo("Alonso")).  
        body("MRData.DriverTable.Drivers[0].nationality", equalTo("Spanish"));  
    }
    
    @Test(priority = 3)
    public void testSeasonDetails() {
        given().
        when().
        get("http://ergast.com/api/f1/constructors/renault/constructorStandings/1/seasons.json").
        then().
        log().all().  
        assertThat().
        body("MRData.SeasonTable.constructorId", equalTo("renault")).  
        body("MRData.SeasonTable.constructorStandings", equalTo("1")). 
        body("MRData.SeasonTable.Seasons[0].season", equalTo("2005")).  
        body("MRData.SeasonTable.Seasons[1].season", equalTo("2006"));  
    }
}
