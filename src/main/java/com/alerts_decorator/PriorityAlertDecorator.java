// PriorityAlertDecorator.java
package com.alerts_decorator;

import com.alerts.Alert;

/**
 * Decorator that tags an alert with a priority level, and
 * prepends it to the condition string.
 */
public class PriorityAlertDecorator extends AlertDecorator {
    private final int priority;

    /**
     * @param alert     the original alert to wrap
     * @param priority  higher numbers = higher urgency
     */
    public PriorityAlertDecorator(Alert alert, int priority) {
        super(alert);
        this.priority = priority;
    }

    // expose the numeric priority if you need it elsewhere
    public int getPriority() {
        return priority;
    }

    // overrides the condition text to include the priority tag
    @Override
    public String getCondition() {
        return "[P" + priority + "] " + decoratedAlert.getCondition();
    }
}
