// SRN: PES2UG23CS363 - Nandan
// File: DonationController.java
// Role in MVC: Controller - Handles donation HTTP requests

package com.donation.controller;

import com.donation.model.Donation;
import com.donation.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/list")
    public String listDonations(Model model) {
        model.addAttribute("donations", donationService.getAllDonations());
        return "donation/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "donation/add";
    }

    @PostMapping("/add")
    public String addDonation(@ModelAttribute Donation donation, RedirectAttributes redirectAttributes) {
        donationService.save(donation);
        redirectAttributes.addFlashAttribute("success", "Donation recorded!");
        return "redirect:/donation/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteDonation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        donationService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Donation deleted.");
        return "redirect:/donation/list";
    }
}
