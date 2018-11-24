package com.codecool.filepartreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "I don't know";
        this.fromLine = 1;
        this.toLine = 2;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws FileNotFoundException {
        File fileToRead = new File(filePath);
        if (!fileToRead.exists()) throw new FileNotFoundException("Haho!");
        if (toLine < fromLine) throw new IllegalArgumentException("Hey!");
        if (fromLine < 1) throw new IllegalArgumentException("Hey hey!");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(this.filePath)));
        return fileContent;
    }

    public String readLines() throws IOException {
        String fileContent = this.read();

        List<String> fileContentList;
        fileContentList = Stream.of(fileContent.split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < fileContentList.size(); i++) {
            if (i < this.fromLine - 1 || i > this.toLine - 1) {
                fileContentList.set(i, "remove");
            }
        }

        fileContentList.removeIf(i -> i.equals("remove"));

        return String.join("\n", fileContentList);
    }
}
