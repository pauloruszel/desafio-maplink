package com.desafio.agendamentomaplink.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  length = 4, precision = 10)
    private Long id;
}
