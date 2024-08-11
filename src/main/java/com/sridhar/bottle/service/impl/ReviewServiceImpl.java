package com.sridhar.bottle.service.impl;

import com.sridhar.bottle.domain.Review;
import com.sridhar.bottle.reponsitory.ReviewRepository;
import com.sridhar.bottle.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);

    }
}
