package com.mercado.mercado.Errors;

public class UsernameNotFoundException extends RuntimeException{
  public UsernameNotFoundException(){
    super("Usuario não encontrado");
  }
}
