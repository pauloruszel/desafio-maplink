package com.desafio.agendamentomaplink.repository;

import com.desafio.agendamentomaplink.domain.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query(" SELECT ag.dataHora, srv.valor" +
            " FROM Agendamento ag " +
            " INNER JOIN ag.servico srv "+
            " GROUP BY ag.dataHora, srv.valor ")
    List<Agendamento> findAllGroupByDataHoraAndServicoValor();
}
