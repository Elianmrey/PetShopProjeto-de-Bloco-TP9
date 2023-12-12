package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.Pagamento;
import br.edu.infnet.appPetShop.model.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Order(5)
@Component
public class PagamentoLoader implements ApplicationRunner {

    @Autowired
    PagamentoService pagamentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String rota = "files/Pagamentos.txt";

        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");


            Pagamento pagamento = getPagamento(dataSet);

            pagamentoService.incluirPagamento(pagamento);

            leitura = leitordeLinha.readLine();
        }
        for (Pagamento Pagamento : pagamentoService.obterPagamentos()) {
            System.out.println("[Pagamento:] " + Pagamento);
        }
    }

    private static Pagamento getPagamento(String[] dataSet) {

        Pagamento pagamento = new Pagamento();

        pagamento.setCartaoCredito(Long.valueOf(dataSet[0]));
        pagamento.setDataVencimento(LocalDate.parse(dataSet[1]));
        pagamento.setCvcCodigoSeguranca(Integer.parseInt(dataSet[2]));
        pagamento.setTokenId(Integer.parseInt(dataSet[3]));


        return pagamento;
    }
}
