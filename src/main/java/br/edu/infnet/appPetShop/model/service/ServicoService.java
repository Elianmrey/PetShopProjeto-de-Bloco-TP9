package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Servico;
import br.edu.infnet.appPetShop.model.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;


    public void incluirServico(Servico servico) {
        servicoRepository.save(servico);
    }

    public Collection<Servico> obterServicos() {
        return (Collection<Servico>) servicoRepository.findAll();
    }
}
