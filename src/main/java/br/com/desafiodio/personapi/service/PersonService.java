package br.com.desafiodio.personapi.service;

import br.com.desafiodio.personapi.dto.request.PersonDTO;
import br.com.desafiodio.personapi.dto.response.MessageResponseDTO;
import br.com.desafiodio.personapi.entity.Person;
import br.com.desafiodio.personapi.exception.PersonNotFoundException;
import br.com.desafiodio.personapi.mapper.PersonMapper;
import br.com.desafiodio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savePerson = personRepository.save(personToSave);
        return createMassegeResponse(savePerson.getId(), "Cadastro de pessoa realizado com êxito.");
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = validationId(id);
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public MessageResponseDTO updatePerson(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        validationId(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMassegeResponse(updatedPerson.getId(), "Atualização de pessoa realizado com êxito.");
    }

    public void delete(Long id) throws PersonNotFoundException{
        validationId(id);
        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMassegeResponse(Long id, String massage) {
        return MessageResponseDTO.builder().message(massage + id).build();
    }

    private Person validationId(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
