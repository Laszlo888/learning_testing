import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JSONPlaceholderTest {

  // You can find a quick description at https://jsonplaceholder.typicode.com/
  // An further instructions at https://jsonplaceholder.typicode.com/guide/
  // Note that the examples are in JS, but the method / body/ header information is language
  // agnostic
  // Add the JSON dependency to your project:
  // testImplementation 'org.json:json:20210307'
  //
  // Create a JSONPlaceholderTest class in your test root
  // Set the base URI to https://jsonplaceholder.typicode.com/ before any tests are ran

  @BeforeAll
  public void setup() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
  }

  // POST
  //
  // Create a test that creates a resource
  // It should use a JSONObject to construct the request body
  // It should use the given().when().then() syntax
  // Assert that all the parameters in the response match up with the request body

  @Test
  public void makePostRequest() {
    // JSONobject stores unordered key-value pairs
    JSONObject requestBody = new JSONObject();
    // userId,id,title comes from API description
    requestBody.put("userId", 4);
    requestBody.put("id", 101);
    requestBody.put("title", "post request");
    requestBody.put("completed", false);

    RestAssured.given()
        .header("Content-type", "application/json; charset=UTF-8")
        // JSONobject toString()
        .body(requestBody.toString())
        .when()
        // /posts comes from api description
        .post("/posts")
        .then()
        .body("id", Matchers.equalTo(101))
        .body("completed", Matchers.equalTo(false))
        .body("userId", Matchers.equalTo(4))
        .body("title", Matchers.equalTo("post request"));
  }

  // PATCH
  //
  // Create a test that updates a resource
  // It should only update one field
  // Assert that the field changed

  @Test
  public void patchUser() {
    JSONObject requestBody = new JSONObject();
    requestBody.put("email", "curtis@something.com");

    RestAssured.given()
        .header("Content-type", "application/json; charset=UTF-8")
        .body(requestBody.toString())
        .when()
        .patch("/users/7")
        .then()
        .body("id", Matchers.equalTo(7))
        .body("username", Matchers.equalTo("Elwyn.Skiles"))
        .body("email", Matchers.equalTo("curtis@something.com"));
  }

  // DELETE
  //
  // Create a test that deletes a resource
  // Assert that the response is empty
  // And the status code is 200

  @Test
  public void deleteUser() {
    String body =
        RestAssured.given().when().delete("/users/3").then().statusCode(200).extract().asString();

    Assertions.assertThat(body).isEqualTo("{}");
  }

  // JSONPath
  //
  // Create a test that gets the /users endpoint
  // It should use JsonPath.getList() to create a List<String> of all the names in the response
  // Assert that all the names are longer than 11 characters

  @Test
  public void namesLongerThanEleven() {
    String body = RestAssured.given().when().get("/users").then().extract().asString();

    // JSONPath works similarly as Xpath
    JsonPath path = new JsonPath(body);
    // getting user names
    List<String> names = path.getList("name");

    for (int i = 0; i < names.size(); i++) {
      Assertions.assertThat(names.get(i).length()).isGreaterThan(11);
    }
  }
}
