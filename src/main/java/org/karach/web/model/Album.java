package org.karach.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "albums")
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "album_id")
  private int albumId;

  @Column(name = "album_title")
  private String albumTitle;

  @Column(name = "album_artist")
  private String albumArtist;

  @Column(name = "album_release_date")
  private Date albumReleaseDate;

  @ManyToOne
  @JoinColumn(name = "track_id")
  private AudioTrack audioTrack;

  public Album() {
  }

  public Album(String albumTitle, String albumArtist, Date albumReleaseDate, AudioTrack audioTrack) {
    this.albumTitle = albumTitle;
    this.albumArtist = albumArtist;
    this.albumReleaseDate = albumReleaseDate;
    this.audioTrack = audioTrack;
  }

  public int getAlbumId() {
    return albumId;
  }

  public void setAlbumId(int albumId) {
    this.albumId = albumId;
  }

  public String getAlbumTitle() {
    return albumTitle;
  }

  public void setAlbumTitle(String albumTitle) {
    this.albumTitle = albumTitle;
  }

  public String getAlbumArtist() {
    return albumArtist;
  }

  public void setAlbumArtist(String albumArtist) {
    this.albumArtist = albumArtist;
  }

  public Date getAlbumReleaseDate() {
    return albumReleaseDate;
  }

  public void setAlbumReleaseDate(Date albumReleaseDate) {
    this.albumReleaseDate = albumReleaseDate;
  }

  public AudioTrack getAudioTrack() {
    return audioTrack;
  }

  public void setAudioTrack(AudioTrack audioTrack) {
    this.audioTrack = audioTrack;
  }
}