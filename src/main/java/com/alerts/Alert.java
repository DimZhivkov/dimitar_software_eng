package com.alerts;

// Represents an alert
public class Alert {
    private String patientId;
    private String condition;
    private long timestamp;
    private double measurementValue;

    public Alert(String patientId, String condition, long timestamp, double measurementValue) {
        this.patientId = patientId;
        this.condition = condition;
        this.timestamp = timestamp;
        this.measurementValue = measurementValue;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getCondition() {
        return condition;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    
}
