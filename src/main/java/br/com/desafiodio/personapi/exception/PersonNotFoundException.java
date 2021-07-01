package br.com.desafiodio.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(Long id){
        super("Nenhuma pessoa encontrada com o Id: "+id);
    }
}
