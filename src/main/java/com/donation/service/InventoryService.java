// SRN: PES2UG23CS379 - Neha Rajkumar Patil
// File: InventoryService.java (copied here for compilation)

package com.donation.service;

import com.donation.model.Inventory;
import java.util.List;

public interface InventoryService {
    Inventory addStock(String bloodType, String organType, int quantity);
    Inventory reduceStock(String bloodType, int quantity);
    boolean checkAvailability(String bloodType);
    List<Inventory> getAllInventory();
    List<Inventory> getLowStockAlerts();
    Inventory getByBloodType(String bloodType);
    Inventory save(Inventory inventory);
}
