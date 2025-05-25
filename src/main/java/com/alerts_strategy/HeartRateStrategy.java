// HeartRateStrategy.java
package com.alerts_strategy;

import com.data_management.PatientRecord;

/**
 * monitors for abnormal heart rates.
 */
public class HeartRateStrategy implements AlertStrategy {
    private static final double HIGH_RATE = 100.0;
    private static final double LOW_RATE  =  60.0;

    @Override
    public boolean checkAlert(PatientRecord record) {
        if (!"HeartRate".equalsIgnoreCase(record.getRecordType())) {
            return false;
        }
        double rate = record.getMeasurementValue();
        return rate > HIGH_RATE || rate < LOW_RATE;
    }
}
