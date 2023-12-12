package br.edu.infnet.appPetShop.model.repository;

import br.edu.infnet.appPetShop.model.domain.Solicitante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Integer> {
}
