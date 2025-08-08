package com.mercado.mercado.Service;

import com.mercado.mercado.Controller.Dtos.LoginDto;
import com.mercado.mercado.Controller.Dtos.UserCreateDto;
import com.mercado.mercado.Errors.UserNotFound;
import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Models.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User getUserById(Long id){
    Optional<User> user = userRepository.findById(id);

    if(user.isEmpty()){
      throw new UserNotFound();
    } else {
      return user.get();
    }
  }
  public User create(User user){
    return userRepository.save(user);
  }

  public User editUser(Long id, UserCreateDto userCreateDto){
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isEmpty()){
      throw new UserNotFound();
    }
    User userFromDb = optionalUser.get();
    userFromDb.setUserName(userCreateDto.userName());
    userFromDb.setEmail(userCreateDto.email());
    userFromDb.setPassword(userCreateDto.password());
    userFromDb.setRole(userCreateDto.role());

    return userRepository.save(userFromDb);
  }

  public void deleteUser(long id){
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isEmpty()){
      throw new UserNotFound();
    }

    userRepository.deleteById(id);

  }

  public UserDetails loadUserByUsername(String username) throws UserNotFound {
    return userRepository.findByUsername(username)
            .orElseThrow(UserNotFound::new);
  }

}
