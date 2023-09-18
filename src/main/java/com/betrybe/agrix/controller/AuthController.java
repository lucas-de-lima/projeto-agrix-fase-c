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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private PersonService personService;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @Autowired
    public AuthController(PersonService personService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.personService = personService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenDto login(@RequestBody LoginBodyDto loginBodyDto) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(loginBodyDto.username(), loginBodyDto.password());
        System.out.println(loginBodyDto.password());

        Authentication auth = authenticationManager.authenticate(usernamePassword);
        Person person = (Person) auth.getPrincipal();
        String token = tokenService.generateToken(person);
        return new TokenDto(token);
    }
}
