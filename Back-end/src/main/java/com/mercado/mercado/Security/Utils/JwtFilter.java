package com.mercado.mercado.Security.Utils;

import com.mercado.mercado.Service.TokenService;
import com.mercado.mercado.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final UserService userService;

  @Autowired
  public JwtFilter(TokenService tokenService, UserService userService) {
    this.tokenService = tokenService;
    this.userService = userService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    Optional<String> token = extractToken(request);

    // (2) verificamos se ele existe
    if (token.isPresent()) {

      // (3) se existir, validamos o token
      String subject = tokenService.validateToken(token.get());

      // (4) se o token for válido (não houve exceção), encontramos a pessoa associada
      UserDetails userDetails = userService.loadUserByUsername(subject);

      // (5) informamos o Spring Security que a pessoa está autenticada
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
              userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // (6) continuamos com a cadeia de filtros de qualquer forma
    filterChain.doFilter(request, response);
  }

  private Optional<String> extractToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null) {
      return Optional.empty();
    }

    return Optional.of(
            authHeader.replace("Bearer ", "")
    );
  }

}