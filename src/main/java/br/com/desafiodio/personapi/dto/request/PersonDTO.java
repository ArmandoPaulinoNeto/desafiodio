package br.com.desafiodio.personapi.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String lastName;

    @NotEmpty
    @Size(min = 14)
    private String cpf;

    private LocalDate birthDay;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phone;
}
