package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader = new FilePartReader();
    private String correctFilePath = "/Users/david/Documents/GitHub/oop-java-filepartreader-with-junit-davidszentesi/src/main/resources/content.txt";

    @Test
    public void setup_IfFileNotExists_ExceptionThrown() {
        assertThrows(FileNotFoundException.class, ()-> filePartReader.setup("incorrectFilePath", 3, 2));
    }

    @Test
    public void setup_IfFromLineGreaterThanToLine_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, ()-> filePartReader.setup(correctFilePath, 3, 2));
    }

    @Test
    public void setup_IfFromLineSmallerThanOne_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, ()-> filePartReader.setup(correctFilePath, -1, 2));
    }

    @Test
    public void read_IfStringEmpty_FailToRead() throws IOException {
        filePartReader.setup(correctFilePath, 1, 1);
        assertFalse(filePartReader.read().isEmpty());
    }

    @Test
    public void readLines_IfNotCorrectLineReturned_FailToRead() throws IOException {
        filePartReader.setup(correctFilePath, 1, 1);
        assertEquals(filePartReader.readLines(), "This is a");
    }
}