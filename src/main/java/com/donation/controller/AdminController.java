// SRN: PES2UG23CS363 - Nandan D
// File: AdminController.java
// Role in MVC: Controller - Admin dashboard

package com.donation.controller;

import com.donation.patterns.singleton.EventManager;
import com.donation.service.DonationService;
import com.donation.service.DonorService;
import com.donation.service.PatientService;
import com.donation.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final DonationService donationService;
    private final DonorService donorService;
    private final PatientService patientService;
    private final InventoryService inventoryService;
    private final EventManager eventManager;

    public AdminController(DonationService donationService,
                            DonorService donorService,
                            PatientService patientService,
                            InventoryService inventoryService,
                            EventManager eventManager) {
        this.donationService = donationService;
        this.donorService = donorService;
        this.patientService = patientService;
        this.inventoryService = inventoryService;
        this.eventManager = eventManager;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalDonors",
            donorService.getAllDonors().size());
        model.addAttribute("totalPatients",
            patientService.getAllPatients().size());
        model.addAttribute("totalDonations",
            donationService.getAllDonations().size());
        model.addAttribute("totalInventory",
            inventoryService.getAllInventory().size());
        model.addAttribute("eventHistory",
            eventManager.getEventHistory());
        model.addAttribute("eventCount",
            eventManager.getEventCount());
        return "admin/dashboard";
    }
}
