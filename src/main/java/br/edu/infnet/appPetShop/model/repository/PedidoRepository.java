package br.edu.infnet.appPetShop.model.repository;

import br.edu.infnet.appPetShop.model.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
