package org.karach.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id")
  private int reviewId;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "track_id")
  private AudioTrack audioTrack;

  @Column(name = "review_text")
  private String reviewText;

  @Column(name = "review_date")
  private Date reviewDate;

  public Review() {
  }

  public Review(User user, AudioTrack audioTrack, String reviewText, Date reviewDate) {
    this.user = user;
    this.audioTrack = audioTrack;
    this.reviewText = reviewText;
    this.reviewDate = reviewDate;
  }

  public int getReviewId() {
    return reviewId;
  }

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  public User getClient() {
    return user;
  }

  public void setClient(User user) {
    this.user = user;
  }

  public AudioTrack getAudioTrack() {
    return audioTrack;
  }

  public void setAudioTrack(AudioTrack audioTrack) {
    this.audioTrack = audioTrack;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public Date getReviewDate() {
    return reviewDate;
  }

  public void setReviewDate(Date reviewDate) {
    this.reviewDate = reviewDate;
  }
}