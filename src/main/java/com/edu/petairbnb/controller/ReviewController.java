package com.edu.petairbnb.controller;


import com.edu.petairbnb.model.Review;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Reviews")
public class ReviewController extends AbstractController<Review>{
    private final ReviewService reviewService;


    @Override
    protected BaseService<Review> getBaseService() {
        return reviewService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Review> getReviews(){
        return this.reviewService.findAll();
    }

}
