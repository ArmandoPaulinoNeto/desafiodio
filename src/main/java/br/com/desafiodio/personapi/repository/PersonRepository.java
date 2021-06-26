package br.com.desafiodio.personapi.repository;

import br.com.desafiodio.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
