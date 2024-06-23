package com.atilas.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "{validation.blank}")
    @Size(max = 80, message = "{validation.size}")
    private String name;
    @NotBlank(message = "{validation.blank}")
    @Size(min = 11, max = 11, message = "{validation.size}")
    private String cpf;
    @NotBlank(message = "{validation.blank}")
    @Size(min = 3, max = 50)
    @Email(message = "{validation.email}")
    private String email;
}
