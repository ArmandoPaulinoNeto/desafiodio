package br.com.desafiodio.personapi.controller;

import br.com.desafiodio.personapi.dto.request.PersonDTO;
import br.com.desafiodio.personapi.dto.response.MessageResponseDTO;
import br.com.desafiodio.personapi.entity.Person;
import br.com.desafiodio.personapi.exception.PersonNotFoundException;
import br.com.desafiodio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }
}
