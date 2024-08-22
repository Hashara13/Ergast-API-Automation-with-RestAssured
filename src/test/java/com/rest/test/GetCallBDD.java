package com.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetCallBDD {
    @Test
    public void testCircuits() {
        given().
        when().
        get("http://ergast.com/api/f1/2015/circuits.json").
        then().
        log().all().  
        assertThat().
        body("MRData.CircuitTable.Circuits.circuitId", notNullValue()). 
        body("MRData.CircuitTable.Circuits.circuitId", hasSize(19)).and()
        .header("current-length", equalTo("4551")); 
    }
}
