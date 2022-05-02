import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TempFileUtilTest {

    //creating temporary folder,temporary folders and files automatically will be deleted after test run,doesn't matter failed or not
    @TempDir
    Path fileDir;

    @Test
    void countLines() throws IOException {
        //creating file
        Path tempPath = fileDir.resolve("first.txt");
        // write into file
        Files.write(tempPath, Collections.singleton("something\nanything\neverything"));
        // check function works well
        assertThat(TempFileUtil.countLines(tempPath)).isEqualTo(3);
    }

    @Test
    void copyFileHappyTest() throws IOException {
        //creating empty files
        Path tempPath1 = fileDir.resolve("file1.txt");
        Path tempPath2 = fileDir.resolve("file2.txt");
        // write into file
        Files.write(tempPath1, Collections.singleton("something\nanything\neverything"));
        // copy file1 to file2
        TempFileUtil.copyFileContent(tempPath1, tempPath2);
        // read from files
        List<String> lines2 = Files.readAllLines(tempPath2);
        List<String> lines1 = Files.readAllLines(tempPath1);
        // check function works well
        assertThat(lines1).isEqualTo(lines2);
    }

    @Test
    void reverseFileContentAndWriteItToAnotherFileHappyTest() throws IOException {
        //creating empty files
        Path tempPath1 = fileDir.resolve("file1.txt");
        Path tempPath2 = fileDir.resolve("file2.txt");
        // write into file
        Files.write(tempPath1, Collections.singleton("3\n2\n1"));
        // copy file1 to file2
        TempFileUtil.reverseOrder(tempPath1, tempPath2);
        // read from files
        List<String> lines2 = Files.readAllLines(tempPath2);
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        // check function works well
        assertThat(lines2).isEqualTo(expected);
    }
}