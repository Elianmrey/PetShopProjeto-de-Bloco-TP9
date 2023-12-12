package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.Brinquedo;
import br.edu.infnet.appPetShop.model.domain.Estoque;
import br.edu.infnet.appPetShop.model.domain.ProdUtilitario;
import br.edu.infnet.appPetShop.model.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
@Order(6)
public class EstoqueLoader implements ApplicationRunner {

    @Autowired
    EstoqueService estoqueService;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        final String rota = "files/Estoque.txt";
        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");


            switch (dataSet[0]) {
                case "B":

                    Brinquedo produtoBrinquedo = getProdutosEstoque(dataSet);
                    Estoque estoqueBrinquedo = new Estoque();
                    estoqueBrinquedo.setProduto(produtoBrinquedo);
                    estoqueBrinquedo.setQtdeUnitaria(Integer.parseInt(dataSet[2]));
                    estoqueBrinquedo.setValorTotalEstoque(Double.parseDouble(dataSet[3]));
                    estoqueBrinquedo.setValidade(LocalDate.parse(dataSet[4]));

                    estoqueService.incluirNoEstoque(estoqueBrinquedo);

                    break;
                case "P":
                    ProdUtilitario produtoUtilitario = getProdutosUtilEstoque(dataSet);

                    Estoque estoqueProduto = new Estoque();

                    estoqueProduto.setProduto(produtoUtilitario);
                    estoqueProduto.setQtdeUnitaria(Integer.parseInt(dataSet[2]));
                    estoqueProduto.setValorTotalEstoque(Double.parseDouble(dataSet[3]));
                    estoqueProduto.setValidade(LocalDate.parse(dataSet[4]));

                    estoqueService.incluirNoEstoque(estoqueProduto);

                    break;
            }

            leitura = leitordeLinha.readLine();

        }
        for (Estoque produto : estoqueService.obterEstoque()) {
            System.out.println("[Produto em Estoque:] " + produto);
        }
    }


    private static Brinquedo getProdutosEstoque(String[] dataSet) {

        Brinquedo brinquedo = new Brinquedo();

        brinquedo.setIdProduto(Integer.parseInt(dataSet[1]));


        return brinquedo;
    }

    private static ProdUtilitario getProdutosUtilEstoque(String[] dataSet) {

        ProdUtilitario produtilitario = new ProdUtilitario();

        produtilitario.setIdProduto(Integer.parseInt(dataSet[1]));

        return produtilitario;
    }


}
