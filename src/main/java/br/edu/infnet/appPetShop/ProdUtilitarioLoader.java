package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.ProdUtilitario;
import br.edu.infnet.appPetShop.model.service.ProdUtilitarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
@Order(3)
@Component
public class ProdUtilitarioLoader implements ApplicationRunner {


    @Autowired
    ProdUtilitarioService prodUtilitarioService;

    @Override

    public void run(ApplicationArguments args) throws Exception  {
        final String rota = "files/ProdutoUtilitario.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");



            ProdUtilitario prodUtilitario = GetProdUtilitario(dataSet);

            prodUtilitarioService.incluirProdUtilitario(prodUtilitario);

            leitura = leitordeLinha.readLine();
        }
        for(ProdUtilitario prodUtilitario: prodUtilitarioService.obterProdUtilitarios() )
        {
            System.out.println("[Produto Utilitario:] " + prodUtilitario);
        }
    }


    private static ProdUtilitario GetProdUtilitario(String[] dataSet) {
        ProdUtilitario prodUtilitario = new ProdUtilitario();


        prodUtilitario.setFabricante(dataSet[0]);
        prodUtilitario.setNome(dataSet[1]);
        prodUtilitario.setTipo(dataSet[2]);
        prodUtilitario.setCategoria(dataSet[4]);
        prodUtilitario.setCodigo(Integer.parseInt(dataSet[4]));
        prodUtilitario.setValor(Double.valueOf(dataSet[5]));
        prodUtilitario.setAvalicaoMedia(Integer.parseInt(dataSet[6]));


        return prodUtilitario;
    }

}
