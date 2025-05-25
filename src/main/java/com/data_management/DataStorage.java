package com.data_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alerts.AlertGenerator;
import java.io.IOException;
import java.util.*;



/**
 * Manages storage and retrieval of patient data within a healthcare monitoring
 * system.
 * This class serves as a repository for all patient records, organized by
 * patient IDs.
 */
public class DataStorage {
    // The sole instance
    private static DataStorage instance;

    private final Map<Integer, Patient> patientMap;

    // Make constructor private to prevent external instantiation
    private DataStorage() {
        this.patientMap = new HashMap<>();
    }

    /**
     * Returns the single DataStorage instance, creating it if necessary.
     */
    public static synchronized DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    public void addPatientData(int patientId, double measurementValue, String recordType, long timestamp) {
        Patient patient = patientMap.computeIfAbsent(patientId, Patient::new);
        patient.addRecord(measurementValue, recordType, timestamp);
    }

    public List<PatientRecord> getRecords(int patientId, long startTime, long endTime) {
        Patient patient = patientMap.get(patientId);
        return (patient != null)
            ? patient.getRecords(startTime, endTime)
            : Collections.emptyList();
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientMap.values());
    }

    public static void main(String[] args) {
        DataStorage storage = DataStorage.getInstance();

        DataReaderFile reader = new DataReaderFile("C:\\Users\\dgddi\\dimitar_software_eng\\csvs");
        try {
            reader.readData(storage);
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
            return;
        }

        AlertGenerator alertGenerator = new AlertGenerator(storage);
        for (Patient p : storage.getAllPatients()) {
            alertGenerator.evaluateData(p);
        }
    }
}
