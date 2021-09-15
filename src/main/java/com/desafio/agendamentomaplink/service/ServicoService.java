package com.desafio.agendamentomaplink.service;

import com.desafio.agendamentomaplink.domain.dto.ServicoDTO;
import com.desafio.agendamentomaplink.domain.model.Servico;
import com.desafio.agendamentomaplink.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService extends BaseService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<ServicoDTO> listarTodos(){
        return servicoRepository.findAll()
                .stream().map(servico -> getConverter().map(servico, ServicoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ServicoDTO salvar(final ServicoDTO dto) {
        final Servico servico = getConverter().map(dto, Servico.class);
        Servico retorno = servicoRepository.save(servico);
        return getConverter().map(retorno, ServicoDTO.class);
    }

    @Transactional
    public ServicoDTO update(final Long id, final ServicoDTO dto) {
        Servico servicoEditado = null;
        Optional<Servico> servicoEncontrado = servicoRepository.findById(id);
        if (servicoEncontrado.isPresent()) {
            servicoEditado = getConverter().map(dto, Servico.class);
        }
        assert servicoEditado != null;
        return getConverter().map(servicoRepository.save(servicoEditado), ServicoDTO.class);
    }
}
