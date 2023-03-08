package com.nd705.project_manager.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
public class ProjectController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "user content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('Admin')")
    public String adminAccess() {
        return "admin content.";
    }

    @GetMapping("/auth")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String authAccess() {
        return "admin or user content";
    }
}