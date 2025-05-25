// BloodOxygenAlertFactory.java
package com.alerts;

import com.alerts.Alert;

public class BloodOxygenAlertFactory extends AlertFactory {
    @Override
    public Alert createAlert(String patientId,
                             String condition,
                             long timestamp,
                             double measurementValue) {
        return new BloodOxygenAlert(patientId, condition, timestamp, measurementValue);
    }
}
