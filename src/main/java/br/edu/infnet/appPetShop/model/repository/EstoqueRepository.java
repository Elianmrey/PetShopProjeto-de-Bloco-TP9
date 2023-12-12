package br.edu.infnet.appPetShop.model.repository;

import br.edu.infnet.appPetShop.model.domain.Estoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer> {
}
