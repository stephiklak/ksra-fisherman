package com.ksra.fisherman.controller;

import com.ksra.fisherman.model.Review;
import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.TechnicianRepository;
import com.ksra.fisherman.repository.UserRepository;
import com.ksra.fisherman.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final TechnicianRepository technicianRepository;
    private final UserRepository userRepository;

    public ReviewController(ReviewService reviewService,
                            TechnicianRepository technicianRepository,
                            UserRepository userRepository) {
        this.reviewService = reviewService;
        this.technicianRepository = technicianRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestParam Long technicianId,
                                               @RequestParam Long customerId,
                                               @RequestParam Integer rating,
                                               @RequestParam String comment) {
        Technician tech = technicianRepository.findById(technicianId)
                .orElseThrow(() -> new RuntimeException("Technician not found"));
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return ResponseEntity.ok(reviewService.createReview(tech, customer, rating, comment));
    }
}
