// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: RequestController.java
// Role in MVC: Controller - Handles request HTTP endpoints

package com.donation.controller;

import com.donation.model.Request;
import com.donation.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/list")
    public String listRequests(Model model) {
        model.addAttribute("requests", requestService.getAllRequests());
        model.addAttribute("emergencyCount",
            requestService.getEmergencyRequests().size());
        return "request/list";
    }

    @GetMapping("/new")
    public String newRequestForm(Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("bloodTypes",
            List.of("A+","A-","B+","B-","AB+","AB-","O+","O-"));
        model.addAttribute("organTypes",
            List.of("KIDNEY","LIVER","HEART","LUNG","CORNEA","NONE"));
        model.addAttribute("urgencyLevels",
            List.of("CRITICAL","HIGH","MEDIUM","LOW"));
        model.addAttribute("requestTypes",
            List.of("BLOOD","ORGAN"));
        return "request/new";
    }

    @PostMapping("/new")
    public String saveRequest(@ModelAttribute Request request,
                               RedirectAttributes redirectAttributes) {
        request.setRequestDate(LocalDate.now());
        request.setStatus("PENDING");
        requestService.save(request);
        redirectAttributes.addFlashAttribute("success",
            "Request submitted successfully!");
        return "redirect:/request/list";
    }

    @PostMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id,
                                @RequestParam String status,
                                RedirectAttributes redirectAttributes) {
        requestService.updateStatus(id, status);
        redirectAttributes.addFlashAttribute("success",
            "Request status updated!");
        return "redirect:/request/list";
    }

    @GetMapping("/emergency")
    public String emergencyRequests(Model model) {
        model.addAttribute("requests",
            requestService.getEmergencyRequests());
        return "request/emergency";
    }
}
