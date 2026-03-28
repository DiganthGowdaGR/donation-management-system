// SRN: PES2UG23CS363 - Nandan D
// File: DonationEventListener.java
// Design Pattern: Observer - Listens for DonationEvent

package com.donation.patterns.observer;

import com.donation.patterns.singleton.EventManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DonationEventListener {

    private final EventManager eventManager;

    public DonationEventListener(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    // Observer Pattern - triggered when DonationEvent is published
    @EventListener
    public void handleDonationEvent(DonationEvent event) {
        System.out.println("EVENT: " + event.getMessage());
        eventManager.recordEvent(event.getMessage());
    }
}
