package com.codecool.filepartreader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private FilePartReader filePartReader = new FilePartReader();
    private FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    private String correctFilePath = "/Users/david/Documents/GitHub/oop-java-filepartreader-with-junit-davidszentesi/src/main/resources/content.txt";

    @DisplayName("Are the words ordered by ABC?")
    @Test
    public void getWordsOrderedAlphabetically_IfWordsNotAlphabetically_FailedToOrder() throws IOException {
        filePartReader.setup(correctFilePath, 1, 2);
        String stringToCompare = "[a, content, interesting, is, This, very]";
        assertEquals(stringToCompare, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @DisplayName("Are the words which contains the specified substring returned?")
    @Test
    public void getWordsContainingSubstring_IfWordNotReturned_FailToReturn() throws IOException {
        filePartReader.setup(correctFilePath, 1, 2);
        String stringToCompare = "[This, is]";
        assertEquals(stringToCompare, fileWordAnalyzer.getWordsContainingSubstring("is").toString());
    }

    @DisplayName("Are the palindromes returned?")
    @Test
    public void getStringsWhichPalindromes_IfWordNotReturned_FailToReturn() throws IOException {
        filePartReader.setup(correctFilePath, 1, 7);
        String stringToCompare = "[a, gezakekazeg]";
        assertEquals(stringToCompare, fileWordAnalyzer.getStringsWhichPalindromes().toString());
    }
}