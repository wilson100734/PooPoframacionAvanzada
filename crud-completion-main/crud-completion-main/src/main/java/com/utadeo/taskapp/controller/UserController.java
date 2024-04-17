package com.utadeo.taskapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utadeo.taskapp.model.User;
import com.utadeo.taskapp.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

  private final IUserService userService;

  UserController(IUserService userService){
    this.userService = userService;
  }

  @PostMapping("usuarios/")
  public User store(@RequestBody User user){
    return this.userService.createUser(user);
  }

  @PutMapping("usuarios/{id}")
  public User update(@RequestBody User user, @PathVariable Long id){
    return this.userService.updateUser(id, user);
  }

  @GetMapping("usuarios/{id}")
  public User showUserById(@PathVariable Long id){
    return this.userService.getById(id);
  }

  @GetMapping("usuarios/list")
  public List<User> showAllUsers() {
    return this.userService.getAllUsers();
  }

  @DeleteMapping("usuarios/{id}")
  public void delete(@PathVariable Long id){
    this.userService.deleteUser(id);
  }


}
