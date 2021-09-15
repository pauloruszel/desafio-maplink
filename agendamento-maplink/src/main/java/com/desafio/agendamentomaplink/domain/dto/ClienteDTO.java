package com.desafio.agendamentomaplink.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements BaseDTO {

    private String nome;
    private String cpf;
}
