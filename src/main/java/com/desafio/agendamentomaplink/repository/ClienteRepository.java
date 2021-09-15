package com.desafio.agendamentomaplink.repository;

import com.desafio.agendamentomaplink.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
