package com.backend.interview.preparation.backend.java.filehandling.charstreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedReaderFileReader {
    public void readFile(Path filePath) throws IOException {
        try(BufferedReader br = Files.newBufferedReader(filePath)) {
            br.lines().forEach(obj -> {
                System.out.println();
            });
        }
    }
}
