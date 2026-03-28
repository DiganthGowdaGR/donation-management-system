// SRN: PES2UG23CS364 - Nandani Sonale
// File: DonorController.java
// Role in MVC: Controller - Handles donor HTTP requests

package com.donation.controller;

import com.donation.model.Donor;
import com.donation.service.DonorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/donor")
public class DonorController {

    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @GetMapping("/list")
    public String listDonors(Model model) {
        model.addAttribute("donors", donorService.getAllDonors());
        return "donor/list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("bloodTypes",
            List.of("A+","A-","B+","B-","AB+","AB-","O+","O-"));
        model.addAttribute("organTypes",
            List.of("KIDNEY","LIVER","HEART","LUNG","CORNEA","NONE"));
        return "donor/register";
    }

    @PostMapping("/register")
    public String registerDonor(@ModelAttribute Donor donor,
                                 RedirectAttributes redirectAttributes) {
        donor.setAvailable(true);
        donorService.save(donor);
        redirectAttributes.addFlashAttribute("success", 
            "Donor registered successfully!");
        return "redirect:/donor/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id,
                               RedirectAttributes redirectAttributes) {
        donorService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Donor deleted.");
        return "redirect:/donor/list";
    }
}
