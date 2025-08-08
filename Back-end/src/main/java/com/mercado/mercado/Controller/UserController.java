package com.mercado.mercado.Controller;

import com.mercado.mercado.Controller.Dtos.UserCreateDto;
import com.mercado.mercado.Controller.Dtos.UserDto;
import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<UserDto> registerUser(@RequestBody UserCreateDto userCreateDto){
    User newUser = userService.create(userCreateDto.toUser());
    return ResponseEntity.status(HttpStatus.CREATED).body(
            new UserDto(newUser.getId(), newUser.getEmail(), newUser.getUsername(), newUser.getName(),newUser.getRole())
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(
            UserDto.fromEntity(
                    userService.getUserById(id)
            )
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDto> editUser(@RequestBody UserCreateDto userCreateDto,
                                          @PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(
            UserDto.fromEntity(userService.editUser(id, userCreateDto))
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity.BodyBuilder deleteUserById(@PathVariable long id){
    return ResponseEntity.status(HttpStatus.OK);
  }
}
