// OxygenSaturationStrategy.java
package com.alerts_strategy;

import com.data_management.PatientRecord;

/**
 * observes oxygen saturation levels for critical changes
 */
public class OxygenSaturationStrategy implements AlertStrategy {
    private static final double SATURATION_THRESHOLD = 92.0;

    @Override
    public boolean checkAlert(PatientRecord record) {
        if (!"OxygenSaturation".equalsIgnoreCase(record.getRecordType())) {
            return false;
        }
        return record.getMeasurementValue() < SATURATION_THRESHOLD;
    }
}
