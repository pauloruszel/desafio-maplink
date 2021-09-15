package com.desafio.agendamentomaplink.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO implements BaseDTO {

    private String codigo;
    private String descricao;
    private String valor;
}
