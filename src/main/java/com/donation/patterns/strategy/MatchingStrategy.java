// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: MatchingStrategy.java
// Design Pattern: Strategy - Interface for matching algorithms

package com.donation.patterns.strategy;

import com.donation.model.Request;
import com.donation.model.Donor;
import java.util.List;

// Strategy Pattern: defines the algorithm interface
public interface MatchingStrategy {
    Donor findBestMatch(Request request, List<Donor> availableDonors);
}
