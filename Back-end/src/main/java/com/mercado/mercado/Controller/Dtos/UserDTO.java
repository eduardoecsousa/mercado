package com.mercado.mercado.Controller.Dtos;

import com.mercado.mercado.Security.Utils.Role;

public record UserDTO(Long id, String email, Role role) {

}
