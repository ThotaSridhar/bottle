package com.sridhar.bottle.controller;

import com.sridhar.bottle.domain.Review;
import com.sridhar.bottle.service.ReviewService;
import com.sridhar.bottle.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping("/review")
    public ResponseEntity<?> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        Review review = reviewRequest.getReview();
        reviewService.addReview(review);
        return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
    }
}
