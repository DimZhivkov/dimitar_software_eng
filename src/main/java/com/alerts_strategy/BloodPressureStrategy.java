// BloodPressureStrategy.java
package com.alerts_strategy;

import com.data_management.PatientRecord;

/**
  checks for type of critical blood pressure readings (systolic or diastolic)
 */
public class BloodPressureStrategy implements AlertStrategy {
    private static final double SYSTOLIC_HIGH  = 180.0;
    private static final double SYSTOLIC_LOW   =  90.0;
    private static final double DIASTOLIC_HIGH = 120.0;
    private static final double DIASTOLIC_LOW  =  60.0;

    @Override
    public boolean checkAlert(PatientRecord record) {
        String type = record.getRecordType();
        double val   = record.getMeasurementValue();

        if ("SystolicPressure".equalsIgnoreCase(type)) {
            return val > SYSTOLIC_HIGH || val < SYSTOLIC_LOW;
        } 
        else if ("DiastolicPressure".equalsIgnoreCase(type)) {
            return val > DIASTOLIC_HIGH || val < DIASTOLIC_LOW;
        }
        return false;
    }
}
