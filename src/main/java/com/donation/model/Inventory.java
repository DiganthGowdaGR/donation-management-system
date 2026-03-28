// SRN: PES2UG23CS379 - Neha Rajkumar Patil
// File: Inventory.java (copied here for compilation)

package com.donation.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private String bloodType;
    private String organType;
    private int quantity;
    private LocalDateTime lastUpdated;

    public void addStock(int units) {
        this.quantity += units;
        this.lastUpdated = LocalDateTime.now();
    }

    public void reduceStock(int units) {
        if (this.quantity >= units) {
            this.quantity -= units;
            this.lastUpdated = LocalDateTime.now();
        }
    }

    public boolean checkAvailability() {
        return this.quantity > 0;
    }

    public String getStockStatus() {
        if (quantity >= 10) return "HIGH";
        else if (quantity >= 5) return "MEDIUM";
        else return "LOW";
    }
}
