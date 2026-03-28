package com.donation.patterns.observer;

import org.springframework.context.ApplicationEvent;

public class DonationEvent extends ApplicationEvent {
    private final Long donorId;
    private final String eventType;
    private final String message;

    public DonationEvent(Object source, Long donorId, String eventType, String message) {
        super(source);
        this.donorId = donorId;
        this.eventType = eventType;
        this.message = message;
    }

    public Long getDonorId() {
        return donorId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }
}
