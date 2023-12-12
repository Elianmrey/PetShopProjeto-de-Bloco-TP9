package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.CarrinhoCompras;
import br.edu.infnet.appPetShop.model.repository.CarrinhoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class CarrinhoComprasService {

    @Autowired
    CarrinhoComprasRepository carrinhoComprasRepository;


    public void incluirCarrinhoCompras(CarrinhoCompras carrinhoCompras) {
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    public Collection<CarrinhoCompras> obterCarrinhoComprass() {
        return (Collection<CarrinhoCompras>) carrinhoComprasRepository.findAll();
    }

}
