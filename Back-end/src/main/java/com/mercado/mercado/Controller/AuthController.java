package com.mercado.mercado.Controller;


import com.mercado.mercado.Controller.Dtos.AuthDto;
import com.mercado.mercado.Controller.Dtos.TokenDto;
import com.mercado.mercado.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  @Autowired
  public AuthController(AuthenticationManager authenticationManager, TokenService tokenService){
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  public TokenDto login(@RequestBody AuthDto authDto) throws Exception{
    try{
      UsernamePasswordAuthenticationToken usernamePassword =
              new UsernamePasswordAuthenticationToken(authDto.userName(), authDto.password());

      Authentication auth = authenticationManager.authenticate(usernamePassword);

      String token = tokenService.generateToken(auth.getName());

      return new TokenDto(token);
    }catch (Exception e){
      throw new Exception(e.getMessage());
    }

  }
}