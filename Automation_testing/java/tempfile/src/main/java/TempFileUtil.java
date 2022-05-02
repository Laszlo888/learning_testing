import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TempFileUtil {

  // Look up your solution for Count lines in the file manipulations workshop
  // Create a TempFileUtil class in your projects java source
  // Copy your count lines function to TempFileUtil
  // Create a TempFileUtilTest class in your projects test source
  // Create a new testcase
  // It should create a tempfile using JUnit
  // Write 3 lines into the file
  // Use AssertJ to test whether your count lines function returns the correct number

  public static int countLines(Path path) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path));
            return lines.size();
        } catch (IOException e) {
            return 0;
        }
    }

  // Look up your solution to Copy file from the file manipulations workshop
  // Copy the method into the TempFileUtil class
  // Create a new testcase in TempFileUtilTest
  // It should create two tempfiles, fill some data into one
  // Use the Copy file method to copy the content of the first file into the second one
  // Use assertJ to determine whether the two files have the same content

  public static void copyFileContent(Path path1, Path path2) {
        try {
            Files.copy(path1, path2);
        } catch (IOException e) {
            System.out.println("Something went wrong. Check paths and try again!");
        }
    }

  // Look up your solution to Reversed order from the file manipulations workshop
  // Copy the method into the TempFileUtil class
  // Refactor it
  // It should work with any file
  // It should write the reversed lines into another file
  // Both files should be provided through parameters
  // Create a new testcase in TempFileUtilTest
  // It should create two tempfiles, fill the first one like so:
  //
  //            3
  //            2
  //            1
  //
  // Use the Reversed order method to copy content of the first file into the second one in reversed order
  // Use AssertJ to determine whether the second file has the content:
  //
  //            1
  //            2
  //            3

  public static void reverseOrder(Path rev, Path rep) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(rev));
            ArrayList<String> linesRepaired = new ArrayList<>();
            for (int i = lines.size() - 1; i > -1; i--) {
                String result = lines.get(i);
                linesRepaired.add(result);
            }
            Files.write(rep, linesRepaired);

        } catch (IOException e) {
            System.out.println("Something went wrong. Check paths and try again!");
        }
    }
}
