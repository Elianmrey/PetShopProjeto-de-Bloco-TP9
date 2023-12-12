package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.Brinquedo;
import br.edu.infnet.appPetShop.model.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
@Component
@Order(4)
public class BrinquedoLoader implements ApplicationRunner {

 @Autowired
    BrinquedoService brinquedoService;

    @Override
     public void run(ApplicationArguments args) throws Exception  {

      final String rota = "files/Brinquedos.txt";

        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            Brinquedo brinquedo = getBrinquedo(dataSet);

            brinquedoService.incluirBrinquedo(brinquedo);

            leitura = leitordeLinha.readLine();
        }
        for(Brinquedo brinquedo: brinquedoService.obterBrinquedos() )
        {
            System.out.println("[Brinquedo:] " + brinquedo);
        }
    }


    private static Brinquedo getBrinquedo(String[] dataSet) {

        Brinquedo brinquedo = new Brinquedo();

        brinquedo.setNome(dataSet[0]);
        brinquedo.setValor(Double.parseDouble(dataSet[1]));
        brinquedo.setCategoria(dataSet[2]);
        brinquedo.setCodigo(Integer.parseInt(dataSet[3]));
        brinquedo.setTipoBrinquedo(dataSet[4]);
        brinquedo.setFabricante(dataSet[5]);
        brinquedo.setAvaliacaoMedia(Integer.parseInt(dataSet[6]));
        brinquedo.setIdadeRecomendada(Integer.parseInt(dataSet[7]));
        brinquedo.setReciclavel(Boolean.parseBoolean(dataSet[8]));

//        Pedido pedido = new Pedido();
//        pedido.setIdPedido(Integer.parseInt(dataSet[9]));
//        brinquedo.setPedido(pedido);

        return brinquedo;
    }

}
