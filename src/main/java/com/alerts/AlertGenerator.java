package com.alerts;

import com.data_management.DataStorage;
import com.data_management.Patient;
import com.data_management.PatientRecord;

/**
 * The {@code AlertGenerator} class is responsible for monitoring patient data
 * and generating alerts when certain predefined conditions are met. This class
 * relies on a {@link DataStorage} instance to access patient data and evaluate
 * it against specific health criteria.
 */
public class AlertGenerator {
    private DataStorage dataStorage;

    /**
     * Constructs an {@code AlertGenerator} with a specified {@code DataStorage}.
     * The {@code DataStorage} is used to retrieve patient data that this class
     * will monitor and evaluate.
     *
     * @param dataStorage the data storage system that provides access to patient
     *                    data
     */
    public AlertGenerator(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    /**
     * Evaluates the specified patient's data to determine if any alert conditions
     * are met. If a condition is met, an alert is triggered via the
     * {@link #triggerAlert}
     * method. This method should define the specific conditions under which an
     * alert
     * will be triggered.
     *
     * @param patient the patient data to evaluate for alert conditions
     */
    public void evaluateData(Patient patient) {
        long currentTime = System.currentTimeMillis();
        long minuteAgo = currentTime - 60 * 1000; // last minute
    
        // Checks records from the last minute
        for (var record : patient.getRecords(minuteAgo, currentTime)) {
            String condition = null;
    
            if (record.getRecordType().equalsIgnoreCase("SystolicPressure") && record.getMeasurementValue() > 180) {
                condition = "High Systolic Pressure";
            } else if (record.getRecordType().equalsIgnoreCase("SystolicPressure") && record.getMeasurementValue() < 90) {
                condition = "Low Systolic Pressure";
            }
    
            if (condition != null) {
                Alert alert = new Alert(String.valueOf(record.getPatientId()), condition, record.getTimestamp());
                triggerAlert(alert);
            }
        }
    }
    

    /**
     * Triggers an alert for the monitoring system. This method can be extended to
     * notify medical staff, log the alert, or perform other actions. The method
     * currently assumes that the alert information is fully formed when passed as
     * an argument.
     *
     * @param alert the alert object containing details about the alert condition
     */
    private void triggerAlert(Alert alert) {
        // Implementation might involve logging the alert or notifying staff
    }
}