package org.karach.web.controller;

import org.karach.web.model.AudioTrack;
import org.karach.web.service.AudioTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audiotracks")
public class AudioTrackController {

  @Autowired
  private AudioTrackService audioTrackService;

  @GetMapping
  public List<AudioTrack> getAllAudioTracks() {
    return audioTrackService.getAllAudioTracks();
  }

  @GetMapping("/{trackId}")
  public AudioTrack getAudioTrackById(@PathVariable long trackId) {
    return audioTrackService.getAudioTrackById(trackId);
  }

  @PostMapping
  public void addAudioTrack(@RequestBody AudioTrack audioTrack) {
    audioTrackService.addAudioTrack(audioTrack);
  }

  @PutMapping("/{trackId}")
  public void updateAudioTrack(@PathVariable long trackId, @RequestBody AudioTrack audioTrack) {
    audioTrackService.updateAudioTrack(trackId, audioTrack);
  }

  @DeleteMapping("/{trackId}")
  public void deleteAudioTrack(@PathVariable long trackId) {
    audioTrackService.deleteAudioTrack(trackId);
  }
}