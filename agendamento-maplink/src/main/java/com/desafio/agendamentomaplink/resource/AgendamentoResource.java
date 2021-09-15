package com.desafio.agendamentomaplink.resource;

import com.desafio.agendamentomaplink.domain.dto.AgendamentoDTO;
import com.desafio.agendamentomaplink.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listarTodosAgendamentos() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

    @GetMapping(path = "/grouping")
    public ResponseEntity<List<AgendamentoDTO>> listarTodosAgrupadosPorDataEValor() {
        return ResponseEntity.ok(agendamentoService.listarTodosAgrupadosPorDataEValor());
    }
}
