package com.backend.interview.preparation.backend.java.filehandling.charstreams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedWriterFileCreation {


    /**
     * This example write an single line, which is 20byte, and repetitive manner.
     * It took 15mins to generate 300MB file
     * @param targetSizeInMB
     * @param filePath
     */
    public void createFile(long targetSizeInMB, Path filePath) throws IOException {
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);

        long targetBytes = targetSizeInMB * 1024 *1024;
        String LINE = "I am file handling.";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile().getAbsolutePath(), Charset.defaultCharset()))) {
            long currentFileSize = 0L;
            //System.out.println("createFile Thread used for writing-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId() +"-currentSize-"+currentFileSize.get()+ "-targetBytes-"+targetBytes);
            while (currentFileSize < targetBytes) {
                bw.write(LINE);
                currentFileSize = currentFileSize + LINE.getBytes(StandardCharsets.UTF_8).length;
                //System.out.println("createFile Thread used for writing-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId() + "-currentSize-"+currentFileSize.get() +"-targetBytes-"+targetBytes);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /***
     * This example write 1MB of string buffer, and repetitive manner. so 300MB/1MB = 300 time only write will happen
     * so 300MB/5MB = 60 time only write will happen
     * @param sizeMB
     * @param filePath
     * @param sizeOfOneBlockInMB
     * @throws IOException
     */
    public void createFile(long sizeMB, Path filePath, int sizeOfOneBlockInMB) throws IOException {
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);

        long targetBytes = sizeMB * 1024L * 1024L;
        int sizeOfOneBlockBytes = sizeOfOneBlockInMB * 1024 * 1024;
        String line = "I am file handling.";
        StringBuilder builder = new StringBuilder(sizeOfOneBlockBytes);
        while (builder.length() < sizeOfOneBlockBytes) {
            builder.append(line);
        }
        String block = builder.toString();
        long blockBytes = block.getBytes(StandardCharsets.UTF_8).length;
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            long written = 0;
            while (written < targetBytes) {
                writer.write(block);
                written += blockBytes;
            }
        }
    }
}
