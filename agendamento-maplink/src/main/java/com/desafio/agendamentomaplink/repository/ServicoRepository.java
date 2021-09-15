package com.desafio.agendamentomaplink.repository;

import com.desafio.agendamentomaplink.domain.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
