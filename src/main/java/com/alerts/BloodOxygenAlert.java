package com.alerts;

public class BloodOxygenAlert extends Alert {
    public BloodOxygenAlert(String patientId, String condition, long timestamp, double measurementValue) {
        super(patientId, condition, timestamp, measurementValue);
    }
}
