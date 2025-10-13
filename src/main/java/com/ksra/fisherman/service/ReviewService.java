package com.ksra.fisherman.service;

import com.ksra.fisherman.model.Review;
import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review createReview(Technician technician, User customer, Integer rating, String comment) {
        Review review = new Review();
        review.setTechnician(technician);
        review.setCustomer(customer);
        review.setRating(rating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }
}
