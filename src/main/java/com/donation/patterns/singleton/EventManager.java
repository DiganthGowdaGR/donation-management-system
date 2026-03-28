// SRN: PES2UG23CS363 - Nandan D
// File: EventManager.java
// Design Pattern: Singleton - Spring creates only ONE instance

package com.donation.patterns.singleton;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

// Singleton Pattern: @Component means Spring creates only one instance
@Component
public class EventManager {

    private final List<String> eventHistory = new ArrayList<>();

    public void recordEvent(String event) {
        eventHistory.add(event);
        System.out.println("[EventManager Singleton] Event: " + event);
    }

    public List<String> getEventHistory() {
        return eventHistory;
    }

    public int getEventCount() {
        return eventHistory.size();
    }
}
