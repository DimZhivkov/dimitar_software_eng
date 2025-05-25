// ECGAlert.java
package com.alerts;

public class ECGAlert extends Alert {
    public ECGAlert(String patientId, String condition, long timestamp, double measurementValue) {
        super(patientId, condition, timestamp, measurementValue);
    }
}
