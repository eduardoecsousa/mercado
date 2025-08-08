package com.mercado.mercado.Controller.Dtos;

import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Security.Utils.Role;

public record UserDto(Long id, String userName, String email, String name, Role role) {
  public static UserDto fromEntity(User user){
    return new UserDto(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getName(),
            user.getRole()
    );
  }
}
