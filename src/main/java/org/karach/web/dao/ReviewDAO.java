package org.karach.web.dao;

import org.karach.web.model.Review;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class ReviewDAO {
  private final EntityManager entityManager;

  public ReviewDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Review getReviewById(long reviewId) {
    return entityManager.find(Review.class, reviewId);
  }

  public List<Review> getAllReviews() {
    return entityManager.createQuery("SELECT r FROM Review r", Review.class).getResultList();
  }

  public void saveReview(Review review) {
    if (review.getReviewId() == 0) {
      entityManager.persist(review);
    } else {
      entityManager.merge(review);
    }
  }

  public void deleteReview(long reviewId) {
    Review review = getReviewById(reviewId);
    if (review != null) {
      entityManager.remove(review);
    }
  }
}