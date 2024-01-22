package org.karach.web.model;
import java.util.Objects;

public class User {

  private int userId;
  private String userName;
  private String userEmail;
  private String userPassword;
  private int clientBonus;
  private String userRole;

  public User() {

  }

  public User(String userName, String userEmail, String userPassword, String userRole) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userRole = userRole;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public int getClientBonus() {
    return clientBonus;
  }

  public void setClientBonus(int clientBonus) {
    this.clientBonus = clientBonus;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return userId == user.userId &&
            clientBonus == user.clientBonus &&
            Objects.equals(userName, user.userName) &&
            Objects.equals(userEmail, user.userEmail) &&
            Objects.equals(userPassword, user.userPassword) &&
            Objects.equals(userRole, user.userRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userName, userEmail, userPassword, clientBonus, userRole);
  }
}