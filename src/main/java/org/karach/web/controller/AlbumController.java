package org.karach.web.controller;

import org.karach.web.model.Album;
import org.karach.web.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

  @Autowired
  private AlbumService albumService;

  @GetMapping
  public List<Album> getAllAlbums() {
    return albumService.getAllAlbums();
  }

  @GetMapping("/{albumId}")
  public Album getAlbumById(@PathVariable long albumId) {
    return albumService.getAlbumById(albumId);
  }

  @PostMapping
  public void addAlbum(@RequestBody Album album) {
    albumService.addAlbum(album);
  }

  @PutMapping("/{albumId}")
  public void updateAlbum(@PathVariable long albumId, @RequestBody Album album) {
    albumService.updateAlbum(albumId, album);
  }

  @DeleteMapping("/{albumId}")
  public void deleteAlbum(@PathVariable long albumId) {
    albumService.deleteAlbum(albumId);
  }
}