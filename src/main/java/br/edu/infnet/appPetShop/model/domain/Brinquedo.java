package br.edu.infnet.appPetShop.model.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Getter
@Setter
@Entity
@Table(name = "TabBrinquedo")
public class Brinquedo extends Produto {


    private String tipoBrinquedo;
    private String fabricante;
    private int avaliacaoMedia;
    private int idadeRecomendada;
    private boolean reciclavel;
    @Transient
    private String reciclavelFormat = reciclavel ? "Sim" : "Não";



	@Override
    public String toString()
    {
        return "[Brinquedo]" + super.toString() +";"+ tipoBrinquedo +";"+ fabricante +";"+ avaliacaoMedia +";"+ idadeRecomendada +";"+ reciclavelFormat;
    }

}