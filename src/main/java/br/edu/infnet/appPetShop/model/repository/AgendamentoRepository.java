package br.edu.infnet.appPetShop.model.repository;

import br.edu.infnet.appPetShop.model.domain.Agendamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> {
}
