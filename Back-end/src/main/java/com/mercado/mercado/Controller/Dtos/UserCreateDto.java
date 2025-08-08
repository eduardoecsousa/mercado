package com.mercado.mercado.Controller.Dtos;

import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Security.Utils.Role;

public record UserCreateDto(String userName, String email, String password, Role role) {

  public User toUser(){
    return new User(userName, email, password, role);
  }
}
