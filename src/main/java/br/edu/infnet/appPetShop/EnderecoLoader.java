package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.Endereco;
import br.edu.infnet.appPetShop.model.domain.Solicitante;
import br.edu.infnet.appPetShop.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
@Component
@Order(2)
public class EnderecoLoader implements ApplicationRunner {


    @Autowired
    EnderecoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception  {
        final String rota = "files/Enderecos.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            Endereco endereco = GetEndereco(dataSet);

            service.incluirEndereco(endereco);

            leitura = leitordeLinha.readLine();
        }
        for(Endereco Endereco: service.obterEnderecos() )
        {
            System.out.println("[Endereco:] " +  Endereco);
        }
    }


    private static Endereco GetEndereco(String[] dataSet) {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(dataSet[0]);
        endereco.setCidade(dataSet[1]);
        endereco.setEstado(dataSet[2]);
        endereco.setCep(dataSet[3]);
        endereco.setNumero(dataSet[4]);
        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(Integer.parseInt(dataSet[5]));
        endereco.setSolicitante(solicitante);

        return endereco;
    }
}
