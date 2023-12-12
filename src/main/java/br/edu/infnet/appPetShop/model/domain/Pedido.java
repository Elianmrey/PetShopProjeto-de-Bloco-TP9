package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "TabPedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;


    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPedido")
    private List<Produto> listaProdutos;

    @OneToMany (cascade = CascadeType.DETACH)
    @JoinColumn(name = "idPedido")
        private List<Servico> listaServico;

    private boolean entrega;
    private double valorTotalPedido;

    @OneToOne (cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSolicitante")
    private Solicitante solicitante;

    @Override
    public String toString (){
        return  (entrega?"Sim":"Não") + ";" + valorTotalPedido + ";" + solicitante.toString();
    }
}
