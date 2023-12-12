package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Pedido;
import br.edu.infnet.appPetShop.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public void incluirPedido(Pedido pedido)
    {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> obterPedidos(){

        return (List<Pedido>)pedidoRepository.findAll();
    }
}
