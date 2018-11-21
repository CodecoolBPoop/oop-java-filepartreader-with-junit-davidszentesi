package com.codecool.filepartreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setFilePath("I don't know");
        setFromLine(1);
        setToLine(10);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setToLine(Integer toLine) {
        this.toLine = toLine;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        setFilePath(filePath);
        if(toLine < fromLine) throw new IllegalArgumentException("Hey!");
        setToLine(toLine);
        if(fromLine < 1) throw new IllegalArgumentException("Hey hey!");
        setFromLine(fromLine);
    }

    public String read() throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(getFilePath())));
        return fileContent;
    }
}
