// BloodPressureAlertFactory.java
package com.alerts;

import com.alerts.Alert;

public class BloodPressureAlertFactory extends AlertFactory {
    @Override
    public Alert createAlert(String patientId, String condition, long timestamp, double measurementValue) {
        return new BloodPressureAlert(patientId, condition, timestamp, measurementValue);
    }
}
