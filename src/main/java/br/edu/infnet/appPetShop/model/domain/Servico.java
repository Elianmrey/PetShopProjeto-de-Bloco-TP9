package br.edu.infnet.appPetShop.model.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "TabServico")
public class Servico {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
    private double valor;
    private String categoria;
    private int avaliacao;
    private String nomeEspecialista;
    private String areaEspecialista;
    private String tipoAtendimento;
    private int codigo;

    @OneToMany
    @JoinColumn(name = "idServico")
    private Collection<Agendamento> agendamento;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idCatalogo")
    private Catalogo catalogo;

	@Override
    public String toString()
    {
        return getValor() + ";" + getCategoria() + ";" + getAvaliacao() + ";" + getNomeEspecialista() + ";" + getAreaEspecialista() + ";" + getTipoAtendimento() + ";" + getCodigo();
    }

}