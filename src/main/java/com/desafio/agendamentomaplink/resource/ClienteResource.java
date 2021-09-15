package com.desafio.agendamentomaplink.resource;

import com.desafio.agendamentomaplink.domain.dto.ClienteDTO;
import com.desafio.agendamentomaplink.repository.ClienteRepository;
import com.desafio.agendamentomaplink.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private final ClienteService clienteService;

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteResource(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes() {
        return ok(clienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO retorno = clienteService.salvar(clienteDTO);
        return status(CREATED).body(retorno);
    }

    @PutMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") long id,
                                             @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO retorno = clienteService.update(id, clienteDTO);
        if (!isNull(retorno)) {
            return ok().body(retorno);
        } else {
            return notFound().build();
        }
    }

    @DeleteMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity <?> deletar(@PathVariable long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.deleteById(id);
                    return ok().build();
                }).orElse(notFound().build());
    }


}
