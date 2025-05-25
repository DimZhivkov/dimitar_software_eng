package com.alerts;

public class BloodPressureAlert extends Alert {
    public BloodPressureAlert(String patientId, String condition, long timestamp, double measurementValue) {
        super(patientId, condition, timestamp, measurementValue);
    }
}