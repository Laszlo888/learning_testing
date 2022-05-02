import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StarWarsAPITest {

  //  Create a setup() method that runs before the tests
  //  It should set the RestAssured.baseURI value to https://swapi.dev
  //  It should set the RestAssured.basePath value to /api

  @BeforeAll
  public void setup() {

    // base URI for example: google.com
    RestAssured.baseURI = "https://swapi.dev";
    // google.com/maps  path is maps, maps is a resource
    RestAssured.basePath = "/api";
  }

  //  Create a test that sends a GET request to /people/1 on top of the base URI and path
  //  Assert that the response took less than 3 seconds to arrive

  @Test
  public void getRequestCheckResponseTime() {

    // (Given) some context to send (header,body,param,cookie)
    // (When) some action is carried out
    // (Method) get,post,put,delete
    // (Then) a particular set of observable consequences should obtain, assertions part

    // at get request no given and now no when
    RestAssured.get("people/1").then().statusCode(200).time(Matchers.lessThan(3000L));
  }

  //  Create a test that sends a GET request to /people/5 on top of the base URI and path
  //  Assert that the response body contains the key hair_color with the value brown

  @Test
  public void getRequestResponseBodyPeople() {
    RestAssured.get("people/5")
        .then()
        .statusCode(200)
        .body("hair_color", Matchers.equalTo("brown"));
  }

  //  Create a test that sends a GET request to /starships/9 on top of the base URI and path
  //  Assert that the response body contains information about the Death Star

  @Test
  public void getRequestResponseBodyStarship() {
    RestAssured.get("starships/9")
        .then()
        .statusCode(200)
        .body("name", Matchers.equalTo("Death Star"));
  }

  //  Create a test that sends a GET request to /species/5 on top of the base URI and path
  //  Assert that the species described in the response starred in two of the films

  @Test
  public void getRequestResponseBodySpecies() {
    RestAssured.get("species/5").then().statusCode(200).body("films", Matchers.hasSize(2));
  }

  //  Figure out how to search for a planet by name
  //  Create a test that searches for Kamino
  //  Assert that there is one result
  //  And it's a planet with the terrain type ocean

  @Test
  public void getRequestForKaminoPlanet() {
    RestAssured.get("planets/?search=Kamino")
        .then()
        .statusCode(200)
        .body("count", Matchers.equalTo(1))
        .and()
        .body("results[0].terrain", Matchers.equalToIgnoringCase("ocean"));
  }

  //  Create a parameterized test
  //  It should validate that the api returns all the correct release dates for every film
  //  Release dates in csv file

  @ParameterizedTest
  @CsvFileSource(resources = "filmReleaseDates.csv", numLinesToSkip = 1)
  public void filmReleaseDatesIsCorrect(int id, String title, String releaseDate) {

    RestAssured.get("films/" + id)
        .then()
        .statusCode(200)
        .body("release_date", Matchers.equalTo(releaseDate));
  }

  //  Create a test that sends a GET request to /species/55 on top of the base URI and path
  //  Assert that the application should return with a 404 response

  @Test
  public void getStatusCode() {
    RestAssured.get("species/55").then().statusCode(404);
  }

  //  Add the following dependency to the project:
  //  implementation 'io.rest-assured:json-schema-validator:4.4.0'
  //  Create a test that sends a GET request to /people/3 on top of the base URI and path
  //  Assert that the response body conforms to this JSON Schema

  @Test
  public void getRequestJSONSchema() {
    RestAssured.get("people/3")
        .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("peopleSchema.json"));
  }
}
