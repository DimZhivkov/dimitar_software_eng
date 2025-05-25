// RepeatedAlertDecorator.java
package com.alerts_decorator;

import com.alerts.Alert;

/**
 * Decorator that repeats delivery of an alert a given number of times,
 * waiting the specified interval between each repetition.
 */
public class RepeatedAlertDecorator extends AlertDecorator {
    private final int repeatCount;
    private final long intervalMillis;

    /**
     * @param alert           the original alert to wrap
     * @param repeatCount     how many times to repeat (in addition to the first)
     * @param intervalMillis  pause between repeats, in milliseconds
     */
    public RepeatedAlertDecorator(Alert alert, int repeatCount, long intervalMillis) {
        super(alert);
        this.repeatCount = repeatCount;
        this.intervalMillis = intervalMillis;
    }

    /**
     * Invoke this to actually perform the repeated delivery.
     * In a real system, replace the println with your alert‐sending logic.
     */
    public void repeatAlert() {
        // First delivery
        deliver(decoratedAlert);
        // Repeat deliveries
        for (int i = 1; i <= repeatCount; i++) {
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            deliver(decoratedAlert);
        }
    }

    private void deliver(Alert alert) {
        System.out.println(
            "REPEAT #" + (/* could track count here */ "?") +
            ": " + alert.getCondition() +
            " for Patient " + alert.getPatientId() +
            " @ " + alert.getTimestamp() +
            " (" + alert.getMeasurementValue() + ")"
        );
    }
}
