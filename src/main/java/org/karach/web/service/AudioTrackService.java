package org.karach.web.service;

import org.karach.web.dao.AudioTrackDAO;
import org.karach.web.model.AudioTrack;

import java.util.List;

public class AudioTrackService {
  private final AudioTrackDAO audioTrackDAO;

  public AudioTrackService(AudioTrackDAO audioTrackDAO) {
    this.audioTrackDAO = audioTrackDAO;
  }

  public void addAudioTrack(AudioTrack audioTrack) {
    audioTrackDAO.saveAudioTrack(audioTrack);
  }

  public void updateAudioTrack(long trackId, AudioTrack audioTrack) {
    audioTrack.setTrackId((int) trackId);
    audioTrackDAO.updateAudioTrack(audioTrack);
  }

  public AudioTrack getAudioTrackById(long audioTrackId) {
    return audioTrackDAO.getAudioTrackById(audioTrackId);
  }

  public List<AudioTrack> getAllAudioTracks() {
    return audioTrackDAO.getAllAudioTracks();
  }

  public void deleteAudioTrack(long audioTrackId) {
    audioTrackDAO.deleteAudioTrack(audioTrackId);
  }
}