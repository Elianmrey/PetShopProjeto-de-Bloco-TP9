package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TabProdutoUtilitario")
public class ProdUtilitario extends Produto {


    private String fabricante;
    private String tipo;
    private int avalicaoMedia;

    @Override
    public String toString() {
        return "[Produto Utilitario]" + super.toString() + fabricante + tipo;
    }


}
