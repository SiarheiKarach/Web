package org.karach.web.controller;

import org.karach.web.model.Review;
import org.karach.web.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @GetMapping
  public List<Review> getAllReviews() {
    return reviewService.getAllReviews();
  }

  @GetMapping("/{reviewId}")
  public Review getReviewById(@PathVariable long reviewId) {
    return reviewService.getReviewById(reviewId);
  }

  @PostMapping
  public void addReview(@RequestBody Review review) {
    reviewService.addReview(review);
  }

  @DeleteMapping("/{reviewId}")
  public void deleteReview(@PathVariable long reviewId) {
    reviewService.deleteReview(reviewId);
  }
}