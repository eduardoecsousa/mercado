package com.mercado.mercado.Models.Entities;

import com.mercado.mercado.Utils.Security.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue
  private long id;

  @Column(unique = true)
  private String email;

  private String password;

  private Role role;

  public User(String email, long id, String password, Role role) {
    this.email = email;
    this.id = id;
    this.password = password;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
