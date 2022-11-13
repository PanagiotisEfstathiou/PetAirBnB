package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Review;
import com.edu.petairbnb.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService {
    private ReviewRepository reviewRepository;
    @Override
    public JpaRepository<Review, Long> getRepository() {
        return reviewRepository;
    }
}
