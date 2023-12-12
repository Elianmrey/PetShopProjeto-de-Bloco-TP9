package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.*;
import br.edu.infnet.appPetShop.model.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogoLoader implements ApplicationRunner {


    @Autowired
    CatalogoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception  {
        final String rota = "files/Catalogos.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            Catalogo Catalogo = GetCatalogo(dataSet);

            service.incluirCatalogo(Catalogo);

            leitura = leitordeLinha.readLine();
        }
        for(Catalogo Catalogo: service.obterCatalogos() )
        {
            System.out.println("[Catalogo:] " +  Catalogo);
        }
    }


    private static Catalogo GetCatalogo(String[] dataSet) {
        Catalogo catalogo = new Catalogo();

        switch (dataSet[0]) {
            case "B":
                Brinquedo brinquedo = new Brinquedo();
                brinquedo.setIdProduto(Integer.parseInt(dataSet[1]));

                List<Produto> listaBrinquedo = new ArrayList<>();
                listaBrinquedo.add(brinquedo);

                if(catalogo.getProdutosLista() == null) {
                    catalogo.setProdutosLista(listaBrinquedo);
                }else
                {
                    catalogo.getProdutosLista().add(brinquedo);
                }
                break;

            case "P":

                ProdUtilitario prodUtilitario = new ProdUtilitario();
                prodUtilitario.setIdProduto(Integer.parseInt(dataSet[1]));

                List<Produto> listaProdutoUtil = new ArrayList<>();
                listaProdutoUtil.add(prodUtilitario);

                if(catalogo.getProdutosLista() == null) {
                    catalogo.setProdutosLista(listaProdutoUtil);
                }else
                {
                    catalogo.getProdutosLista().add(prodUtilitario);
                }


                break;
        }

        Servico servico = new Servico();
        servico.setIdServico(Integer.parseInt(dataSet[2]));

       if(catalogo.getServicosLista() == null) {
           List<Servico> listaServico = new ArrayList<>();
           listaServico.add(servico);
           catalogo.setServicosLista(listaServico);
       } else
       {
           catalogo.getServicosLista().add(servico);
       }

        catalogo.setQtdeProdsServ(Integer.parseInt(dataSet[3]));
        catalogo.setEstado(Boolean.parseBoolean(dataSet[4]));

        return catalogo;
    }

}
