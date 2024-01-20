package org.karach.web.service;

import org.karach.web.dao.AlbumDAO;
import org.karach.web.model.Album;

import java.util.List;

public class AlbumService {
  private final AlbumDAO albumDAO;

  public AlbumService(AlbumDAO albumDAO) {
    this.albumDAO = albumDAO;
  }

  public void addAlbum(Album album) {
    albumDAO.saveAlbum(album);
  }

  public void updateAlbum(long albumId, Album album) {
    albumDAO.updateAlbum(albumId, album);
  }

  public Album getAlbumById(long albumId) {
    return albumDAO.getAlbumById(albumId);
  }

  public List<Album> getAllAlbums() {
    return albumDAO.getAllAlbums();
  }

  public void deleteAlbum(long albumId) {
    albumDAO.deleteAlbum(albumId);
  }
}