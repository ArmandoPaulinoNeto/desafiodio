package br.com.desafiodio.personapi.service;

import br.com.desafiodio.personapi.dto.request.PersonDTO;
import br.com.desafiodio.personapi.dto.response.MessageResponseDTO;
import br.com.desafiodio.personapi.entity.Person;
import br.com.desafiodio.personapi.exception.PersonNotFoundException;
import br.com.desafiodio.personapi.mapper.PersonMapper;
import br.com.desafiodio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

       public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savePerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Pessoa inserida com sucesso " + savePerson.getId()).build();
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = validationId(id);
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public void delete(Long id) throws PersonNotFoundException{
        validationId(id);
        personRepository.deleteById(id);
    }

    public Person validationId(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
