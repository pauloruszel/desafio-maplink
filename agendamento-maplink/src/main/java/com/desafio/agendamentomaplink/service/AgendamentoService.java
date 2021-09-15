package com.desafio.agendamentomaplink.service;

import com.desafio.agendamentomaplink.domain.dto.AgendamentoDTO;
import com.desafio.agendamentomaplink.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService extends BaseService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<AgendamentoDTO> listarTodos(){
        return agendamentoRepository.findAll()
                .stream().map(agendamento -> getConverter().map(agendamento, AgendamentoDTO.class))
                .collect(Collectors.toList());
    }


    public List<AgendamentoDTO> listarTodosAgrupadosPorDataEValor(){
        return agendamentoRepository.findAllGroupByDataHoraAndServicoValor()
                .stream().map(agendamento -> getConverter().map(agendamento, AgendamentoDTO.class))
                .collect(Collectors.toList());
    }
}
