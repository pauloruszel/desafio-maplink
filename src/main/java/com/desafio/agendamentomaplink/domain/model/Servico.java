package com.desafio.agendamentomaplink.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AttributeOverride(name = "id", column = @Column(name = "idServico", unique = true, nullable = false, length = 4, precision = 10))
@Table(	name = "TB_Servico")
public class Servico extends BaseEntity {

    @NotBlank
    @Column(name = "codigo", length = 50, nullable = false)
    private String codigo;

    @NotBlank
    @Column(name = "descricao", length = 250, nullable = false)
    private String descricao;

    @NotBlank
    @Column(name = "valor", length = 25, nullable = false)
    private String valor;

}
