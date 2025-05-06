package com.data_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DataReaderFile implements DataReader {

    private String outputDir;

    public DataReaderFile (String outputDir) {
        this.outputDir = outputDir;
    }

    @Override
    public void readData(DataStorage dataStorage) throws IOException {
        File directory = new File(outputDir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("Invalid output directory: " + outputDir);
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in directory: " + outputDir);
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".csv")) {
                processFile(file, dataStorage);
            }
        }
    }

    private void processFile(File file, DataStorage dataStorage) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue;

                String[] tokens = line.split(",");
                if (tokens.length != 4) {
                    System.err.println("Skipping malformed line " + lineNumber);
                    continue;
                }

                try {
                    int patientId = Integer.parseInt(tokens[0].trim());
                    double measurementValue = Double.parseDouble(tokens[1].trim());
                    String recordType = tokens[2].trim();
                    long timestamp = Long.parseLong(tokens[3].trim());

                    dataStorage.addPatientData(patientId, measurementValue, recordType, timestamp);
                }
                catch (NumberFormatException e) {
                    System.err.println("Skipping invalid data on line " + lineNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read file: " + file.getName() + " - " + e.getMessage());
        }
    }
}
