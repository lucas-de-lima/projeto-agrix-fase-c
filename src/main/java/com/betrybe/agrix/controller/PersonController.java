package com.betrybe.agrix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betrybe.agrix.controller.dto.PersonBodyDto;
import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.util.ModelDtoConverter;

/**
 * PersonController.
 */
@RestController
public class PersonController {
  public final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create a person.
   */
  @PostMapping("/persons")
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody PersonBodyDto personBodyDto) {
    Person person = ModelDtoConverter.dtoToPerson(personBodyDto);
    Person createdPerson = personService.create(person);
    return ModelDtoConverter.personToDto(createdPerson);
  }

}
