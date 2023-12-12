package br.edu.infnet.appPetShop.model.service;

import br.edu.infnet.appPetShop.model.domain.Catalogo;
import br.edu.infnet.appPetShop.model.domain.Catalogo;
import br.edu.infnet.appPetShop.model.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CatalogoService {

    @Autowired
    CatalogoRepository catalogoRepository;


    public void incluirCatalogo(Catalogo catalogo) {
        catalogoRepository.save(catalogo);
    }

    public Collection<Catalogo> obterCatalogos() {
        return (Collection<Catalogo>) catalogoRepository.findAll();
    }

}
