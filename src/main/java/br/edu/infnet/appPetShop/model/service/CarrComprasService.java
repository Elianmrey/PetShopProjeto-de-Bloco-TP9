package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.CarrinhoCompras;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CarrComprasService {

    private final Map<Integer, CarrinhoCompras> mapa = new HashMap<>();

    public void adicionarCarrinhoCompras(CarrinhoCompras carrinhoCompras)
    {
        mapa.put(carrinhoCompras.getIdCarrinho(), carrinhoCompras);
    }

    public List<CarrinhoCompras> obterCarrinhoComprass(){

        return mapa.values().stream().toList();
    }
}
