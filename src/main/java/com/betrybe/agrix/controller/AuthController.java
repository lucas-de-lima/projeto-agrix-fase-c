package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.LoginBodyDto;
import com.betrybe.agrix.controller.dto.TokenDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para autenticação.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final PersonService personService;
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  /**
   * Construtor.
   *
   * @param personService         O serviço de pessoa
   * @param authenticationManager O gerenciador de autenticação
   * @param tokenService          O serviço de token
   */
  @Autowired
  public AuthController(
          PersonService personService,
          AuthenticationManager authenticationManager,
          TokenService tokenService
  ) {
    this.personService = personService;
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  /**
   * Endpoint para autenticar um usuário.
   *
   * @param loginBodyDto Os dados de login
   * @return Um DTO de token
   */
  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  public TokenDto login(@RequestBody LoginBodyDto loginBodyDto) {
    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(loginBodyDto.username(), loginBodyDto.password());  
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    Person person = (Person) auth.getPrincipal();
    String token = tokenService.generateToken(person);
    return new TokenDto(token);
  }

}
