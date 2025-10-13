package com.ksra.fisherman.controller;

import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.UserRepository;
import com.ksra.fisherman.service.TechnicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;
    private final UserRepository userRepository;

    public TechnicianController(TechnicianService technicianService, UserRepository userRepository) {
        this.technicianService = technicianService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<Technician>> getAllTechnicians() {
        return ResponseEntity.ok(technicianService.getAllTechnicians());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable Long id) {
        return ResponseEntity.ok(technicianService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Technician> createTechnician(@RequestParam Long userId,
                                                       @RequestParam String skills,
                                                       @RequestParam Integer experienceYears) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(technicianService.createTechnician(user, skills, experienceYears));
    }
}
