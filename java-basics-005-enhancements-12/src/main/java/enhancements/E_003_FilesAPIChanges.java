package enhancements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *  Files.mismatch(Path, Path) :
 *      -   mismatch() method compares two file paths and return a long value. The long indicates the
 *          position of the first mismatched byte in the content of the two files. The return value
 *          will be '–1' if the files are “equal.”
 */
public class E_003_FilesAPIChanges {

    public static void main(String[] args) throws IOException {
        Path hello = Paths.get("/Users/tarun/Desktop/Softwares/workspace/intellij/github/" +
                "core-java-learning/java-basics-005-enhancements-12/src/main/resources")
                .resolve("hello.txt");

        Path hello1 = Paths.get("/Users/tarun/Desktop/Softwares/workspace/intellij/github/" +
                "core-java-learning/java-basics-005-enhancements-12/src/main/resources")
                .resolve("hello-1.txt");

        long diff = Files.mismatch(hello, hello1); //returns long value
        System.out.println(diff);
    }
}
