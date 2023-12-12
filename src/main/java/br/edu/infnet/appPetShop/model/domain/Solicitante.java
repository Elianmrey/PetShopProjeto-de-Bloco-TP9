package br.edu.infnet.appPetShop.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TabSolicitante")
public class Solicitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSolicitante;
	private String nome;
	private String cpf;
	private String email;

	private String tipoPet;




	@Override
	public String toString() {
		return "Nome: " + getNome() + "; CPF: " + getCpf() + "; E-mail: " + getEmail() + "; Tipo de Pet: " + getTipoPet();
	}


}





