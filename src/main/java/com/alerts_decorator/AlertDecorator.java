// AlertDecorator.java
package com.alerts_decorator;

import com.alerts.Alert;

/**
 * Base decorator for Alert, forwarding all calls to the wrapped Alert.
 */
public abstract class AlertDecorator extends Alert {
    protected final Alert decoratedAlert;

    public AlertDecorator(Alert decoratedAlert) {
        super(
            decoratedAlert.getPatientId(),
            decoratedAlert.getCondition(),
            decoratedAlert.getTimestamp(),
            decoratedAlert.getMeasurementValue()
        );
        this.decoratedAlert = decoratedAlert;
    }

    @Override
    public String getPatientId() {
        return decoratedAlert.getPatientId();
    }

    @Override
    public String getCondition() {
        return decoratedAlert.getCondition();
    }

    @Override
    public long getTimestamp() {
        return decoratedAlert.getTimestamp();
    }

    @Override
    public double getMeasurementValue() {
        return decoratedAlert.getMeasurementValue();
    }
}
