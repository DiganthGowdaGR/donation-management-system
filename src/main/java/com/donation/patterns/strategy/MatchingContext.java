// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: MatchingContext.java
// Design Pattern: Strategy - Context that selects which strategy to use

package com.donation.patterns.strategy;

import com.donation.model.Donor;
import com.donation.model.Request;
import org.springframework.stereotype.Component;
import java.util.List;

// Strategy Pattern: Context class
// Decides which matching strategy to use based on urgency
@Component
public class MatchingContext {

    private final HighPriorityMatchingStrategy highPriorityStrategy;
    private final NormalMatchingStrategy normalStrategy;

    public MatchingContext(HighPriorityMatchingStrategy highPriorityStrategy,
                           NormalMatchingStrategy normalStrategy) {
        this.highPriorityStrategy = highPriorityStrategy;
        this.normalStrategy = normalStrategy;
    }

    public Donor executeMatching(Request request, List<Donor> donors) {
        // Strategy Pattern: select strategy based on urgency level
        MatchingStrategy strategy;
        if ("CRITICAL".equals(request.getUrgencyLevel()) ||
            "HIGH".equals(request.getUrgencyLevel())) {
            // Use high priority strategy
            strategy = highPriorityStrategy;
            System.out.println("[Strategy] Using HIGH PRIORITY matching");
        } else {
            // Use normal strategy
            strategy = normalStrategy;
            System.out.println("[Strategy] Using NORMAL matching");
        }
        return strategy.findBestMatch(request, donors);
    }
}
