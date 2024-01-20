package org.karach.web.service;

import org.karach.web.dao.UserDAO;
import org.karach.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
  public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
      this.userDAO = userDAO;
    }

    public User getUserById(long userId) {
      return userDAO.getUserById(userId);
    }

    public List<User> getAllUsers() {
      return userDAO.getAllUsers();
    }

    public void addUser(User user) {
      userDAO.saveUser(user);
    }

    public void updateUser(long userId, User user) {
      userDAO.updateUser(user);
    }

    public void deleteUser(long userId) {
      userDAO.deleteUser(userId);
    }

    public void assignBonusToUser(long userId, int bonusAmount) {
      User user = userDAO.getUserById(userId);

      if (user != null) {
        int currentBonus = user.getClientBonus();
        user.setClientBonus(currentBonus + bonusAmount);

        userDAO.updateUser(user);
      } else {
        throw new IllegalArgumentException("User not found with ID: " + userId);
      }
    }
  }