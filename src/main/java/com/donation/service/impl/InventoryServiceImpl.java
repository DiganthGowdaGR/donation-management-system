// SRN: PES2UG23CS379 - Neha Rajkumar Patil

package com.donation.service.impl;

import com.donation.model.Inventory;
import com.donation.repository.InventoryRepository;
import com.donation.service.InventoryService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory addStock(String bloodType, String organType, int quantity) {
        Optional<Inventory> existing = inventoryRepository.findByBloodType(bloodType);
        Inventory inventory;
        if (existing.isPresent()) {
            inventory = existing.get();
            inventory.addStock(quantity);
        } else {
            inventory = new Inventory();
            inventory.setBloodType(bloodType);
            inventory.setOrganType(organType != null ? organType : "NONE");
            inventory.setQuantity(quantity);
            inventory.setLastUpdated(LocalDateTime.now());
        }
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory reduceStock(String bloodType, int quantity) {
        Inventory inventory = inventoryRepository.findByBloodType(bloodType)
            .orElseThrow(() -> new RuntimeException("Not found: " + bloodType));
        inventory.reduceStock(quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public boolean checkAvailability(String bloodType) {
        return inventoryRepository.findByBloodType(bloodType)
            .map(Inventory::checkAvailability).orElse(false);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<Inventory> getLowStockAlerts() {
        return inventoryRepository.findByQuantityLessThan(5);
    }

    @Override
    public Inventory getByBloodType(String bloodType) {
        return inventoryRepository.findByBloodType(bloodType)
            .orElseThrow(() -> new RuntimeException("Not found: " + bloodType));
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
