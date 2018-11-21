package com.codecool.filepartreader;

import java.io.IOException;

public class FileWordAnalyzer {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath("/Users/david/Documents/GitHub/oop-java-filepartreader-with-junit-davidszentesi/src/main/resources/content.txt");
        System.out.println(filePartReader.read());
    }


}
