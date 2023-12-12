package br.edu.infnet.appPetShop.model.repository;


import br.edu.infnet.appPetShop.model.domain.ProdUtilitario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdUtilitarioRepository extends CrudRepository<ProdUtilitario, Integer> {
}