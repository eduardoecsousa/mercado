package com.mercado.mercado.Service;


import com.mercado.mercado.Controller.Dtos.UserCreateDto;
import com.mercado.mercado.Errors.UsernameNotFoundException;
import com.mercado.mercado.Models.Entities.User;
import com.mercado.mercado.Models.Repositories.UserRepository;
import com.mercado.mercado.Service.Utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User getUserById(Long id){
    Optional<User> user = userRepository.findById(id);

    if(user.isEmpty()){
      throw new UsernameNotFoundException();
    } else {
      return user.get();
    }
  }
  public User create(User user){
    String hashedPassword = new BCryptPasswordEncoder()
            .encode(user.getPassword());

    user.setPassword(hashedPassword);
    return userRepository.save(user);
  }

  public User editUser(Long id, UserCreateDto userCreateDto){
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isEmpty()){
      throw new UsernameNotFoundException();
    }
    User userFromDb = optionalUser.get();
    userFromDb.setUserName(userCreateDto.userName());
    userFromDb.setEmail(userCreateDto.email());
    userFromDb.setPassword(userCreateDto.password());
    userFromDb.setRole(userCreateDto.role());

    return userRepository.save(userFromDb);
  }

  public List<User> findAllUsers(){
    return userRepository.findAll();
  }

  public void deleteUser(long id){
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isEmpty()){
      throw new UsernameNotFoundException();
    }

    userRepository.deleteById(id);

  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUserName(username)
            .orElseThrow(UsernameNotFoundException::new);
    return new CustomUserDetails(user);
  }

}
