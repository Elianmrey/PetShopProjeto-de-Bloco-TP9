package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.*;
import br.edu.infnet.appPetShop.model.service.CarrinhoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarrComprasLoader implements ApplicationRunner {



    @Autowired
    CarrinhoComprasService service;

    @Override
    public void run(ApplicationArguments args) throws Exception  {
        final String rota = "files/CarrinhoCompras.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            CarrinhoCompras CarrinhoCompras = GetCarrinhoCompras(dataSet);

            service.incluirCarrinhoCompras(CarrinhoCompras);

            leitura = leitordeLinha.readLine();
        }
        for(CarrinhoCompras CarrinhoCompras: service.obterCarrinhoComprass() )
        {
            System.out.println("[CarrinhoCompras:] " +  CarrinhoCompras);
        }
    }


    private static CarrinhoCompras GetCarrinhoCompras(String[] dataSet) {
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        switch (dataSet[0]) {
            case "B":
                Brinquedo brinquedo = new Brinquedo();
                brinquedo.setIdProduto(Integer.parseInt(dataSet[1]));

                List<Produto> listaBrinquedo = new ArrayList<>();
                listaBrinquedo.add(brinquedo);

                if(carrinhoCompras.getListCompraProdutos() == null) {
                    carrinhoCompras.setListCompraProdutos(listaBrinquedo);
                }else
                {
                    carrinhoCompras.getListCompraProdutos().add(brinquedo);
                }
                break;

            case "P":

                ProdUtilitario prodUtilitario = new ProdUtilitario();
                prodUtilitario.setIdProduto(Integer.parseInt(dataSet[1]));

                List<Produto> listaProdutoUtil = new ArrayList<>();
                listaProdutoUtil.add(prodUtilitario);

                if(carrinhoCompras.getListCompraProdutos() == null) {
                    carrinhoCompras.setListCompraProdutos(listaProdutoUtil);
                }else
                {
                    carrinhoCompras.getListCompraProdutos().add(prodUtilitario);
                }


                break;
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setIdAgendamento(Integer.parseInt(dataSet[2]));

        if(carrinhoCompras.getListAgendamentoServicos() == null) {
            List<Agendamento> listaAgendamento = new ArrayList<>();
            listaAgendamento.add(agendamento);
            carrinhoCompras.setListAgendamentoServicos(listaAgendamento);
        } else
        {
            carrinhoCompras.getListAgendamentoServicos().add(agendamento);
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamentos(Integer.parseInt(dataSet[3]));
        carrinhoCompras.setPagamento(pagamento);

        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(Integer.parseInt(dataSet[4]));

        carrinhoCompras.setSolicitante(solicitante);
carrinhoCompras.setCuponDeconto(dataSet[5]);

        return carrinhoCompras;
    }
}
