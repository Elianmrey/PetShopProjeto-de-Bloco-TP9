package br.edu.infnet.appPetShop.model.repository;

import br.edu.infnet.appPetShop.model.domain.Servico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository  extends CrudRepository<Servico, Integer> {

}
