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
    public DataStorage dataStorage; // fixed yellow underlining when switch to public idk

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
        //long currentTime = System.currentTimeMillis();
        //long minuteAgo = currentTime - 60 * 1000; // last minute

        long currentTime = 200;
        long minuteAgo = 1; // last minute
    
        // Checks records from the last minute
        for (PatientRecord record : patient.getRecords(minuteAgo, currentTime)) {
            String condition = null;
    
            if (record.getRecordType().equalsIgnoreCase("SystolicPressure") && record.getMeasurementValue() > 180.0) {
                condition = "High Systolic Pressure";
            }
            else if (record.getRecordType().equalsIgnoreCase("SystolicPressure") && record.getMeasurementValue() < 90.0) {
                condition = "Low Systolic Pressure";
            }
            else if (record.getRecordType().equalsIgnoreCase("DiastolicPressure") && record.getMeasurementValue() > 120.0) {
                condition = "High Diastolic Pressure";
            }
            else if (record.getRecordType().equalsIgnoreCase("DiastolicPressure") && record.getMeasurementValue() < 60.0) {
                condition = "Low Diastolic Pressure";
            }
            else if (record.getRecordType().equalsIgnoreCase("OxygenSaturation") && record.getMeasurementValue() < 92.0) {
                condition = "Low Diastolic Pressure";
            }
    
            if (condition != null) {
                Alert alert = new Alert(String.valueOf(record.getPatientId()), condition, record.getTimestamp(), record.getMeasurementValue());
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
        System.out.println(alert.getCondition() + " of (" + alert.getMeasurementValue() + ") for Patient (" + alert.getPatientId() + ") at time (" + alert.getTimestamp() + ")");
    }
}