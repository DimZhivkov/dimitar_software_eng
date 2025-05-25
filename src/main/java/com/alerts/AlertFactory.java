
package com.alerts;

import com.alerts.Alert;

/**
 * Factory Method base class for creating Alert instances.
 */
public abstract class AlertFactory {
    /**
     * Creates an Alert for the given patient under the specified condition at the given time,
     * including the measurement value that triggered it.
     *
     * @param patientId        unique ID of the patient
     * @param condition        description of the condition triggering the alert
     * @param timestamp        when the alert occurred (ms since epoch)
     * @param measurementValue the numeric measurement value that caused the alert
     * @return                 a concrete Alert instance
     */
    public abstract Alert createAlert(String patientId,
                                      String condition,
                                      long timestamp,
                                      double measurementValue);
}
