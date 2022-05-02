import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Create a new test for a simple file download.
// Use REST Assured to download the following file: http://the-internet.herokuapp.com/download/note.txt
// Assert that the file contains the expected content.

public class DownloadWithRestAssured {

  @Test
  public void fileDownloadWithRestAssured() throws IOException {

    // get string from txt file
    // This makes a GET request and returns the body as a string.
    String responseString =
        RestAssured.given()
            .when()
            .get("http://the-internet.herokuapp.com/download/notes.txt")
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .asString();

    assertThat(responseString).isNotEmpty();

    // create directory for downloaded files
    Path path = Paths.get("downloadedFiles");
    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      System.err.println("Failed to create directory!" + e.getMessage());
    }

    // write content to file
    try {
      Files.write(Paths.get("downloadedFiles/note.txt"), Collections.singleton(responseString));
    } catch (IOException e) {
      System.out.println("File writing failed.");
    }

    // compare with original file
    List<String> base = Files.readAllLines(Paths.get("src/test/resources/compairingFiles/notes.txt"));
    List<String> downloaded = Files.readAllLines(Paths.get("downloadedFiles/notes.txt"));

    assertThat(base)
        .as("Downloaded file content should be the same as one on server.")
        .isEqualTo(downloaded);
  }
}
