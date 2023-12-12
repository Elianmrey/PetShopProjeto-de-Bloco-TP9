package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.*;
import br.edu.infnet.appPetShop.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Order(4)
@Component
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    PedidoService service;

    @Override

    public void run(ApplicationArguments args) throws Exception {

        final String rota = "files/pedidos.txt";
        FileReader arquivo;
        arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");


            Pedido Pedido = GetPedido(dataSet);

            service.incluirPedido(Pedido);

            leitura = leitordeLinha.readLine();
        }
        for (Pedido Pedido : service.obterPedidos()) {
            System.out.println("[Pedido:] " + Pedido);
        }
    }


    private static Pedido GetPedido(String[] dataSet) {
        Pedido pedido = new Pedido();


        switch (dataSet[0]) {
            case "B":
                Brinquedo brinquedo = new Brinquedo();
                brinquedo.setIdProduto(Integer.parseInt(dataSet[1]));

                List<Produto> listaBrinquedo = new ArrayList<>();
                listaBrinquedo.add(brinquedo);

                if (pedido.getListaProdutos() == null) {
                    pedido.setListaProdutos(listaBrinquedo);
                } else {
                    pedido.getListaProdutos().add(brinquedo);
                }
                break;

            case "P":

                ProdUtilitario prodUtilitario = new ProdUtilitario();
                prodUtilitario.setIdProduto(Integer.parseInt(dataSet[1]));


                if (pedido.getListaProdutos() == null) {
                    List<Produto> listaProdutoUtil = new ArrayList<>();
                    listaProdutoUtil.add(prodUtilitario);
                    pedido.setListaProdutos(listaProdutoUtil);
                } else {
                    pedido.getListaProdutos().add(prodUtilitario);
                }


                break;
        }

        Servico servico = new Servico();

        servico.setIdServico(Integer.parseInt(dataSet[2]));

        if (pedido.getListaServico() == null) {
            List<Servico> listaservico = new ArrayList<>();
            listaservico.add(servico);
            pedido.setListaServico(listaservico);
        } else {
            pedido.getListaServico().add(servico);
        }

        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(Integer.parseInt(dataSet[3]));
        pedido.setSolicitante(solicitante);

        pedido.setEntrega(Boolean.getBoolean(dataSet[4]));
        pedido.setValorTotalPedido(Double.parseDouble(dataSet[2]));


        return pedido;
    }
}
