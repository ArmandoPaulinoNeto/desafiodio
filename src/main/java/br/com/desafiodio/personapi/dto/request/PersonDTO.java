package br.com.desafiodio.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String lastName;

    @NotEmpty
    @Size(min = 14, max = 14)
    private String cpf;

    private String birthDay;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phone;
}
