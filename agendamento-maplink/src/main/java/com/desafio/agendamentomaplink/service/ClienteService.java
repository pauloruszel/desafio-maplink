package com.desafio.agendamentomaplink.service;

import com.desafio.agendamentomaplink.domain.dto.ClienteDTO;
import com.desafio.agendamentomaplink.domain.model.Cliente;
import com.desafio.agendamentomaplink.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService extends BaseService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listarTodos(){
        return clienteRepository.findAll()
                .stream().map(cliente -> getConverter().map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ClienteDTO salvar(final ClienteDTO dto) {
        final Cliente cliente = getConverter().map(dto, Cliente.class);
        Cliente retorno = clienteRepository.save(cliente);
        return getConverter().map(retorno, ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO update(final Long id, final ClienteDTO dto) {
        Cliente colaboradorEditado = null;
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        if (clienteEncontrado.isPresent()) {
            colaboradorEditado = getConverter().map(dto, Cliente.class);
        }
        assert colaboradorEditado != null;
        return getConverter().map(clienteRepository.save(colaboradorEditado), ClienteDTO.class);
    }

}
