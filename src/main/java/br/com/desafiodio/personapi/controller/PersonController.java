package br.com.desafiodio.personapi.controller;

import br.com.desafiodio.personapi.dto.response.MessageResponseDTO;
import br.com.desafiodio.personapi.entity.Person;
import br.com.desafiodio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Pessoa inserida com sucesso" + savePerson.getId()).build();
    }
}
