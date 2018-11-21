package com.codecool.filepartreader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    private Stream<String> fileContent() throws IOException {
        return Stream.of(filePartReader.readLines().split("\\W+"));
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        return fileContent().sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        return fileContent().filter(string -> string.contains(subString))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        return fileContent().filter(string -> string.toLowerCase()
                .equals(new StringBuilder(string).reverse().toString().toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
