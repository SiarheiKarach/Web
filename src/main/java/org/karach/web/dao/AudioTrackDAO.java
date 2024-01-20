package org.karach.web.dao;

import org.karach.web.model.AudioTrack;

import javax.persistence.EntityManager;
import java.util.List;

public class AudioTrackDAO {
  private final EntityManager entityManager;

  public AudioTrackDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public AudioTrack getAudioTrackById(long trackId) {
    return entityManager.find(AudioTrack.class, trackId);
  }

  public List<AudioTrack> getAllAudioTracks() {
    return entityManager.createQuery("SELECT a FROM AudioTrack a", AudioTrack.class).getResultList();
  }

  public void saveAudioTrack(AudioTrack audioTrack) {
    if (audioTrack.getTrackId() == 0) {
      entityManager.persist(audioTrack);
    } else {
      entityManager.merge(audioTrack);
    }
  }

  public void updateAudioTrack(AudioTrack audioTrack) {
    entityManager.merge(audioTrack);
  }

  public void deleteAudioTrack(long trackId) {
    AudioTrack audioTrack = getAudioTrackById(trackId);
    if (audioTrack != null) {
      entityManager.remove(audioTrack);
    }
  }
}