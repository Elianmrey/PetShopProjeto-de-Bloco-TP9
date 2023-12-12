package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Estoque;
import br.edu.infnet.appPetShop.model.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public void incluirNoEstoque(Estoque estoque)
    {
        estoqueRepository.save(estoque);
    }

    public List<Estoque> obterEstoque(){

        return (List<Estoque>)estoqueRepository.findAll();
    }
}
