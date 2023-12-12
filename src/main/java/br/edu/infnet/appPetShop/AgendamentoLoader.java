package br.edu.infnet.appPetShop;

import br.edu.infnet.appPetShop.model.domain.Agendamento;
import br.edu.infnet.appPetShop.model.domain.Servico;
import br.edu.infnet.appPetShop.model.domain.Solicitante;
import br.edu.infnet.appPetShop.model.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;



@Component
@Order(8)
public class AgendamentoLoader implements ApplicationRunner {

    @Autowired
    AgendamentoService agendamentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String rota = "files/Agendamentos.txt";
        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");

            Agendamento agendament = getAgendamento(dataSet, LocalDate.parse(dataSet[2]));

            agendamentoService.incluirAgendamento(agendament);

            leitura = leitordeLinha.readLine();
        }

        for (Agendamento agendamento : agendamentoService.obterAgendamentos()) {
            System.out.println("[Agendamento:] " + agendamento);
        }
    }

    private static Agendamento getAgendamento(String[] dataSet, LocalDate dataHora)
    {
        var solicitante = getSolicitante(dataSet);
        var servico = getServico(dataSet);

       Agendamento agendamento = new Agendamento();
       agendamento.setServico(servico);
       agendamento.setSolicitante(solicitante);
       agendamento.setDataHora(dataHora);

        return  agendamento;

    }
    private static Solicitante getSolicitante(String[] dataSet) {

        Solicitante solicitante = new Solicitante();

        solicitante.setIdSolicitante(Integer.valueOf(dataSet[0]));
        
        return solicitante;
    }

    private static Servico getServico(String[] dataSet) {

        Servico servico = new Servico();

        servico.setIdServico(Integer.parseInt(dataSet[1]));

        return servico;
    }


}


