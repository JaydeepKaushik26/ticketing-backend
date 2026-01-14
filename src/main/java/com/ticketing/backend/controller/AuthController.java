package com.ticketing.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String email) {

        String role;

        if (email.equalsIgnoreCase("admin@test.com")) {
            role = "ADMIN";
        } else if (email.equalsIgnoreCase("support@test.com")) {
            role = "SUPPORT";
        } else {
            role = "USER";
        }

        return Map.of(
                "userId", 1,
                "email", email,
                "role", role
        );
    }

    @PostMapping("/logout")
    public Map<String, String> logout() {
        return Map.of("message", "Logged out");
    }
}
