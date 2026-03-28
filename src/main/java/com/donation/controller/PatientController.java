// SRN: PES2UG23CS364 - Nandani Sonale
// File: PatientController.java
// Role in MVC: Controller - Handles patient HTTP requests

package com.donation.controller;

import com.donation.model.Patient;
import com.donation.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patient/list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("bloodTypes",
            List.of("A+","A-","B+","B-","AB+","AB-","O+","O-"));
        model.addAttribute("organTypes",
            List.of("KIDNEY","LIVER","HEART","LUNG","CORNEA","NONE"));
        model.addAttribute("urgencyLevels",
            List.of("CRITICAL","HIGH","MEDIUM","LOW"));
        return "patient/register";
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute Patient patient,
                                   RedirectAttributes redirectAttributes) {
        patientService.save(patient);
        redirectAttributes.addFlashAttribute("success",
            "Patient registered successfully!");
        return "redirect:/patient/list";
    }

    @PostMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id,
                                 RedirectAttributes redirectAttributes) {
        patientService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Patient deleted.");
        return "redirect:/patient/list";
    }
}
