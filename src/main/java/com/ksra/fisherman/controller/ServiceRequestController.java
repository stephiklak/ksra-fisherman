package com.ksra.fisherman.controller;

import com.ksra.fisherman.model.ServiceRequest;
import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.TechnicianRepository;
import com.ksra.fisherman.repository.UserRepository;
import com.ksra.fisherman.service.ServiceRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;
    private final UserRepository userRepository;
    private final TechnicianRepository technicianRepository;

    public ServiceRequestController(ServiceRequestService serviceRequestService,
                                    UserRepository userRepository,
                                    TechnicianRepository technicianRepository) {
        this.serviceRequestService = serviceRequestService;
        this.userRepository = userRepository;
        this.technicianRepository = technicianRepository;
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllRequests() {
        return ResponseEntity.ok(serviceRequestService.getAllRequests());
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createRequest(@RequestParam Long customerId,
                                                        @RequestParam(required = false) Long technicianId,
                                                        @RequestParam String description,
                                                        @RequestParam Double lat,
                                                        @RequestParam Double lng) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Technician tech = null;
        if (technicianId != null) {
            tech = technicianRepository.findById(technicianId)
                    .orElseThrow(() -> new RuntimeException("Technician not found"));
        }
        return ResponseEntity.ok(serviceRequestService.createRequest(customer, tech, description, lat, lng));
    }
}
