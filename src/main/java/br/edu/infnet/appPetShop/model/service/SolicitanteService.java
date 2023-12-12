package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Solicitante;
import br.edu.infnet.appPetShop.model.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public class SolicitanteService {

    @Autowired
    SolicitanteRepository solicitanteRepository;


    public void incluirSolicitante(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }

    public Collection<Solicitante> obterSolicitantes() {
        return (Collection<Solicitante>) solicitanteRepository.findAll();
    }
}