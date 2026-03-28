// SRN: PES2UG23CS364 - Nandani Sonale
// File: DonationEvent.java
// Design Pattern: Observer - Event object published when donation occurs

package com.donation.patterns.observer;

import org.springframework.context.ApplicationEvent;

public class DonationEvent extends ApplicationEvent {

    private Long donorId;
    private String eventType;
    private String message;

    public DonationEvent(Object source, Long donorId, 
                          String eventType, String message) {
        super(source);
        this.donorId = donorId;
        this.eventType = eventType;
        this.message = message;
    }

    public Long getDonorId() { return donorId; }
    public String getEventType() { return eventType; }
    public String getMessage() { return message; }
}
