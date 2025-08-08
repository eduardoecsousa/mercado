package com.mercado.mercado.Controller;

import com.mercado.mercado.Controller.Dtos.UserCreateDto;
import com.mercado.mercado.Controller.Dtos.UserDTO;
import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<UserDTO> registerUser(@RequestBody UserCreateDto userCreateDto){
    User newUser = userService.create(userCreateDto.toUser());
    return ResponseEntity.status(HttpStatus.CREATED).body(
            new UserDTO(newUser.getId(), newUser.getEmail(), newUser.getRole())
    );
  }
}
