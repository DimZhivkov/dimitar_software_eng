// AlertStrategy.java
package com.alerts_strategy;

import com.data_management.PatientRecord;

public interface AlertStrategy {
    boolean checkAlert(PatientRecord record);
}
