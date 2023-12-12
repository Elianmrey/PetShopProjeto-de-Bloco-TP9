package br.edu.infnet.appPetShop;


import br.edu.infnet.appPetShop.model.domain.Pedido;
import br.edu.infnet.appPetShop.model.domain.Servico;
import br.edu.infnet.appPetShop.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(2)
public class ServicoLoader implements ApplicationRunner {

    @Autowired
      ServicoService servicoService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String rota = "files/Servicos.txt";
        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");

            leitura = leitordeLinha.readLine();
            Servico servico = getServico(dataSet);

            servicoService.incluirServico(servico);

        }
        for (Servico servico : servicoService.obterServicos()) {
            System.out.println("[Serviço:] " + servico);
        }
    }


    private static Servico getServico(String[] dataSet) {


        Servico servico = new Servico();

        servico.setValor(Double.parseDouble(dataSet[0]));
        servico.setCategoria(dataSet[1]);
        servico.setAvaliacao(Integer.parseInt(dataSet[2]));
        servico.setNomeEspecialista(dataSet[3]);
        servico.setAreaEspecialista(dataSet[4]);
        servico.setTipoAtendimento(dataSet[5]);
        servico.setCodigo(Integer.parseInt(dataSet[6]));


        return servico;
    }


}
