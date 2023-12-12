package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "tabCatalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCatalogo;


    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCatalogo")
    private List<Produto> produtosLista;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCatalogo")
    private List<Servico> servicosLista;

    private int qtdeProdsServ;

    private boolean estado;

    private final String categoria = estado ? " Ativo" : " Em Estoque";

@Override
    public String toString()
{
    return  qtdeProdsServ + categoria;
}

}
