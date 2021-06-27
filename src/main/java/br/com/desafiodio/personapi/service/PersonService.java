package br.com.desafiodio.personapi.service;

import br.com.desafiodio.personapi.dto.request.PersonDTO;
import br.com.desafiodio.personapi.dto.response.MessageResponseDTO;
import br.com.desafiodio.personapi.entity.Person;
import br.com.desafiodio.personapi.mapper.PersonMapper;
import br.com.desafiodio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savePerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Pessoa inserida com sucesso " + savePerson.getId()).build();
    }
}
