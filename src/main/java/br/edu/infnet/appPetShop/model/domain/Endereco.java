package br.edu.infnet.appPetShop.model.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TabEndereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    @ManyToOne (cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSolicitante")
    Solicitante solicitante;



	@Override
    public String toString()
    {
        return "Rua: "+getLogradouro() + ", Número: " + getNumero() + " ," + getCidade() + " - " + getEstado() + ". CEP: " + getCep() + ". ";
    }
}