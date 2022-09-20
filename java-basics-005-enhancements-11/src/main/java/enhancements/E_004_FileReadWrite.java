package enhancements;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *  -   Using these overloaded methods, Java 11 aims to reduce a lot of boilerplate code which
 *      makes much easier to read and write files.
 */
public class E_004_FileReadWrite {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Read file as string
        URI txtFileUri = E_004_FileReadWrite.class.getClassLoader().getResource("hello.txt").toURI();
        String content = Files.readString(Path.of(txtFileUri), Charset.defaultCharset());
        System.out.println(content);
        //Write string to file
        Path tmpFilePath = Path.of(File.createTempFile("hello", ".txt").toURI());
        Path returnedFilePath = Files.writeString(tmpFilePath,"Hello World!", Charset.defaultCharset(), StandardOpenOption.WRITE);
        System.out.println(returnedFilePath);
    }
}
