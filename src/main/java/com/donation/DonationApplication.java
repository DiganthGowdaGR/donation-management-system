// SRN: PES2UG24CS823 - Sharath Gowda GR
// File: DonationApplication.java
// Role in MVC: Main Entry (Config)

package com.donation;

/**
 * Main entry point for the application.
 *
 * This project uses the Spring Boot MVC architecture, which separates the application into three main components:
 * - Model: Handles data and business logic (to be implemented)
 * - View: Manages UI rendering using Thymeleaf templates
 * - Controller: Handles HTTP requests and responses (to be implemented)
 *
 * The MVC pattern promotes separation of concerns, making the application modular, testable, and maintainable.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonationApplication {
    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }
}
