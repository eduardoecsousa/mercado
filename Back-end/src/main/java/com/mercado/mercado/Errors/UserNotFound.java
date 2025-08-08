package com.mercado.mercado.Errors;

public class UserNotFound extends RuntimeException{
  public UserNotFound(){
    super("Usuario não encontrado");
  }
}
