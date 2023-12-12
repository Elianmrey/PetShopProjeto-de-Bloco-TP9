package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TabProduto")
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    private String nome;
    private double valor;
    private String categoria;
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idCatalogo")
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "idCarrinho")
    private CarrinhoCompras carrinhoCompras;
	@Override
    public String toString()
    {
        return nome +";"+ valor +";"+ categoria +";"+ codigo;
    }

}
