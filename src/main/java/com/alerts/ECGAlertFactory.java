// ECGAlertFactory.java
package com.alerts;

import com.alerts.Alert;

public class ECGAlertFactory extends AlertFactory {
    @Override
    public Alert createAlert(String patientId,
                             String condition,
                             long timestamp,
                             double measurementValue) {
        return new ECGAlert(patientId, condition, timestamp, measurementValue);
    }
}
