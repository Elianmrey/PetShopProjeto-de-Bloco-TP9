package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TabEstoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstoque;
    @ManyToOne (cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private int qtdeUnitaria;
    private double valorTotalEstoque;
    private LocalDate validade;

    @Override
    public String toString()
    {
        return produto.toString() + " Quantidade: " + qtdeUnitaria + " Valor total de Estoque: " + valorTotalEstoque + " Data Validade: " + validade;
    }

}