package com.desafio.agendamentomaplink.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AttributeOverride(name = "id", column = @Column(name = "idCliente", unique = true, nullable = false, length = 4, precision = 10))
@Table(	name = "TB_Cliente")
public class Cliente extends BaseEntity {

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @CPF
    @NotBlank
    @Size(max = 14)
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
}
