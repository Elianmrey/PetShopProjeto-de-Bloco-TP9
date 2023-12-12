package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Agendamento;
import br.edu.infnet.appPetShop.model.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service

public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;


    public void incluirAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }

    public Collection<Agendamento> obterAgendamentos() {
        return (Collection<Agendamento>) agendamentoRepository.findAll();
    }
}
