package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Pagamento;
import br.edu.infnet.appPetShop.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public void incluirPagamento(Pagamento pagamento)
    {
        pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> obterPagamentos(){

        return (List<Pagamento>)pagamentoRepository.findAll();
    }
}
