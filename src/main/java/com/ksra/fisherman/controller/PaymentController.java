package com.ksra.fisherman.controller;

import com.ksra.fisherman.model.Payment;
import com.ksra.fisherman.model.ServiceRequest;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.ServiceRequestRepository;
import com.ksra.fisherman.repository.UserRepository;
import com.ksra.fisherman.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final UserRepository userRepository;
    private final ServiceRequestRepository serviceRequestRepository;

    public PaymentController(PaymentService paymentService,
                             UserRepository userRepository,
                             ServiceRequestRepository serviceRequestRepository) {
        this.paymentService = paymentService;
        this.userRepository = userRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestParam Long customerId,
                                                 @RequestParam Long serviceRequestId,
                                                 @RequestParam Double amount) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        ServiceRequest request = serviceRequestRepository.findById(serviceRequestId)
                .orElseThrow(() -> new RuntimeException("Service request not found"));
        return ResponseEntity.ok(paymentService.createPayment(customer, request, amount));
    }
}
