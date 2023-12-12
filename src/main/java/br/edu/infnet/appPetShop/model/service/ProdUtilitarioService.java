package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.ProdUtilitario;
import br.edu.infnet.appPetShop.model.repository.ProdUtilitarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdUtilitarioService {

    @Autowired
    private ProdUtilitarioRepository prodUtilitarioRepository;

    public void incluirProdUtilitario(ProdUtilitario prodUtilitario)
    {
        prodUtilitarioRepository.save(prodUtilitario);
    }

    public List<ProdUtilitario> obterProdUtilitarios(){

        return (List<ProdUtilitario>)prodUtilitarioRepository.findAll();
    }
}
