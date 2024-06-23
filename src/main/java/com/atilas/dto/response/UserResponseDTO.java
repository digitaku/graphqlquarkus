package com.atilas.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
}
