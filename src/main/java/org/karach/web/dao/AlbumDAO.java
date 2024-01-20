package org.karach.web.dao;

import org.karach.web.model.Album;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class AlbumDAO {
  private final EntityManager entityManager;

  public AlbumDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Album getAlbumById(long albumId) {
    return entityManager.find(Album.class, albumId);
  }

  public List<Album> getAllAlbums() {
    return entityManager.createQuery("SELECT a FROM Album a", Album.class).getResultList();
  }

  public void saveAlbum(Album album) {
    if (album.getAlbumId() == 0) {
      entityManager.persist(album);
    } else {
      entityManager.merge(album);
    }
  }

  public void updateAlbum(long albumId, Album album) {
    Album existingAlbum = getAlbumById(albumId);
    if (existingAlbum != null) {
      existingAlbum.setAlbumTitle(album.getAlbumTitle());
      existingAlbum.setAlbumArtist(album.getAlbumArtist());
      existingAlbum.setAlbumReleaseDate(album.getAlbumReleaseDate());

      entityManager.merge(existingAlbum);
    }
  }

  public void deleteAlbum(long albumId) {
    Album album = getAlbumById(albumId);
    if (album != null) {
      entityManager.remove(album);
    }
  }
}