package com.mercado.mercado.Models.Repositories;

import com.mercado.mercado.Models.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmailAndPassword(String email, String password);

  Optional<User> findByUsername(String username);
}
