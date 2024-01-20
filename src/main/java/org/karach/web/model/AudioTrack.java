package org.karach.web.model;

import javax.persistence.*;

@Entity
@Table(name = "audiotracks")
public class AudioTrack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "track_id")
  private int trackId;

  @Column(name = "track_title")
  private String trackTitle;

  @Column(name = "track_artist")
  private String trackArtist;

  @Column(name = "track_genre")
  private String trackGenre;

  @Column(name = "track_price")
  private double trackPrice;


  public AudioTrack() {
  }

  public AudioTrack(String trackTitle, String trackArtist, String trackGenre, double trackPrice) {
    this.trackTitle = trackTitle;
    this.trackArtist = trackArtist;
    this.trackGenre = trackGenre;
    this.trackPrice = trackPrice;
  }

  public int getTrackId() {
    return trackId;
  }

  public void setTrackId(int trackId) {
    this.trackId = trackId;
  }

  public String getTrackTitle() {
    return trackTitle;
  }

  public void setTrackTitle(String trackTitle) {
    this.trackTitle = trackTitle;
  }

  public String getTrackArtist() {
    return trackArtist;
  }

  public void setTrackArtist(String trackArtist) {
    this.trackArtist = trackArtist;
  }

  public String getTrackGenre() {
    return trackGenre;
  }

  public void setTrackGenre(String trackGenre) {
    this.trackGenre = trackGenre;
  }

  public double getTrackPrice() {
    return trackPrice;
  }

  public void setTrackPrice(double trackPrice) {
    this.trackPrice = trackPrice;
  }
}