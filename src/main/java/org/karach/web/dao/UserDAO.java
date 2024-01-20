package org.karach.web.dao;

import org.karach.web.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Component
public class UserDAO {
  private final EntityManager entityManager;

  public UserDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public User getUserById(long userId) {
    return entityManager.find(User.class, userId);
  }

  public List<User> getAllUsers() {
    Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
    return query.getResultList();
  }

  public void saveUser(User user) {
    if (user.getUserId() == 0) {
      entityManager.persist(user);
    } else {
      entityManager.merge(user);
    }
  }

  public void updateUser(User user) {
    entityManager.merge(user);
  }

  public void deleteUser(long userId) {
    User user = getUserById(userId);
    if (user != null) {
      entityManager.remove(user);
    }
  }
}