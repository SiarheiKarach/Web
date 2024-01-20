package org.karach.web.controller;

import org.karach.web.model.User;
import org.karach.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{userId}")
  public User getUserById(@PathVariable long userId) {
    return userService.getUserById(userId);
  }

  @PostMapping
  public void addUser(@RequestBody User user) {
    userService.addUser(user);
  }

  @PutMapping("/{userId}")
  public void updateUser(@PathVariable long userId, @RequestBody User user) {
    userService.updateUser(userId, user);
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable long userId) {
    userService.deleteUser(userId);
  }
}