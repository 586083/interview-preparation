package com.backend.interview.preparation.backend.java.filehandling.charstreams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;

public class BufferedWriterFileCreationTest {

    /**
     * Creating 300MB file, took 15mins
     * @throws IOException
     */
    @Test
    public void BufferedWriterFileCreationTest() throws IOException {
        LocalDateTime startTime = LocalDateTime.now();
        BufferedWriterFileCreation bufferedWriterFileCreation = new BufferedWriterFileCreation();
        bufferedWriterFileCreation.createFile(300, Path.of("src/main/resources/filehandling/sample-file-300mb.txt"));
        LocalDateTime endTime = LocalDateTime.now();
        Duration totalTimeTaken = Duration.between(startTime, endTime);
        // Extract individual total units
        long hours = totalTimeTaken.toHoursPart();
        long minutes = totalTimeTaken.toMinutesPart();
        long seconds = totalTimeTaken.toSecondsPart();
        System.out.println("startTime-"+startTime+"-End Time"+endTime+"Time Taken:"+ hours+" hours,"+minutes+" minutes, "+ seconds+" seconds");
    }

    /***
     * Creating 300MB file, less than one seconds
     * startTime-2026-07-23T20:14:06.825845-End Time-2026-07-23T20:14:08.013856Time Taken-0 hours,0 minutes, 1 seconds
     */
    @Test
    public void BufferedWriterFileCreationTest_WithBlockWrite_5MB_300MB() throws IOException {
        LocalDateTime startTime = LocalDateTime.now();
        BufferedWriterFileCreation bufferedWriterFileCreation = new BufferedWriterFileCreation();
        bufferedWriterFileCreation.createFile(300, Path.of("src/main/resources/filehandling/sample-file-300mb.txt") , 5);
        LocalDateTime endTime = LocalDateTime.now();
        Duration totalTimeTaken = Duration.between(startTime, endTime);
        // Extract individual total units
        long hours = totalTimeTaken.toHoursPart();
        long minutes = totalTimeTaken.toMinutesPart();
        long seconds = totalTimeTaken.toSecondsPart();
        System.out.println("startTime-"+startTime+"-End Time-"+endTime+"Time Taken-"+ hours+" hours,"+minutes+" minutes, "+ seconds+" seconds");
    }

    /***
     * Creating 2 GB file, and each block of 5MB, it takes 10seconds
     * startTime-2026-07-23T20:16:29.863938-End Time-2026-07-23T20:16:39.951501Time Taken-0 hours,0 minutes, 10 seconds
     */
    @Test
    public void BufferedWriterFileCreationTest_WithBlockWrite_5MB_2GB() throws IOException {
        LocalDateTime startTime = LocalDateTime.now();
        BufferedWriterFileCreation bufferedWriterFileCreation = new BufferedWriterFileCreation();
        bufferedWriterFileCreation.createFile(2046, Path.of("src/main/resources/filehandling/sample-file-2gb.txt") , 5);
        LocalDateTime endTime = LocalDateTime.now();
        Duration totalTimeTaken = Duration.between(startTime, endTime);
        // Extract individual total units
        long hours = totalTimeTaken.toHoursPart();
        long minutes = totalTimeTaken.toMinutesPart();
        long seconds = totalTimeTaken.toSecondsPart();
        System.out.println("startTime-"+startTime+"-End Time-"+endTime+"Time Taken-"+ hours+" hours,"+minutes+" minutes, "+ seconds+" seconds");
    }
}
