package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Brinquedo;
import br.edu.infnet.appPetShop.model.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BrinquedoService {

    @Autowired
    BrinquedoRepository BrinquedoRepository;

    public void incluirBrinquedo(Brinquedo brinquedo)
    {
        BrinquedoRepository.save(brinquedo);
    }

    public List<Brinquedo> obterBrinquedos(){

        return (List<Brinquedo>)BrinquedoRepository.findAll();
    }
}
