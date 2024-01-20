  package org.karach.web.service;

  import org.karach.web.dao.ReviewDAO;
  import org.karach.web.model.Review;

  import java.util.List;

  public class ReviewService {
    private final ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
      this.reviewDAO = reviewDAO;
    }

    public void addReview(Review review) {
      reviewDAO.saveReview(review);
    }

    public Review getReviewById(long reviewId) {
      return reviewDAO.getReviewById(reviewId);
    }

    public List<Review> getAllReviews() {
      return reviewDAO.getAllReviews();
    }

    public void deleteReview(long reviewId) {
      reviewDAO.deleteReview(reviewId);
    }
  }