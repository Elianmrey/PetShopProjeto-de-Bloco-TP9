package br.edu.infnet.appPetShop;


import br.edu.infnet.appPetShop.model.domain.Solicitante;
import br.edu.infnet.appPetShop.model.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;



@Component
@Order(1)
public class SolicitanteLoader implements ApplicationRunner {

    @Autowired
    SolicitanteService service;

    @Override

    public void run(ApplicationArguments args) throws Exception  {
      final String rota = "files/Solicitantes.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            Solicitante cliente = GetSolicitante(dataSet);

            service.incluirSolicitante(cliente);

            leitura = leitordeLinha.readLine();
        }
        for(Solicitante solicitante: service.obterSolicitantes() )
        {
            System.out.println("[Solicitante:] " +  solicitante);
        }
    }


    private static Solicitante GetSolicitante(String[] dataSet) {
        Solicitante cliente = new Solicitante();
        cliente.setNome(dataSet[0]);
        cliente.setCpf(dataSet[1]);
        cliente.setEmail(dataSet[2]);
        cliente.setTipoPet(dataSet[3]);
        
        return cliente;
    }


}