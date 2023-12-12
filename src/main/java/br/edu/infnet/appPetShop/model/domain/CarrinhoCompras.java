package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TabCarrinhoCompras")
public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrinho;
    @OneToOne
    @JoinColumn(name = "idPagamento")
    private Pagamento pagamento;
    private String cuponDeconto;
    @OneToOne
    @JoinColumn(name = "idCarrinho")
    private Solicitante solicitante;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCarrinho")
    private List<Produto> listCompraProdutos;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCarrinho")
    private List<Agendamento> listAgendamentoServicos;

    @Override
    public String toString()
    {
        return  pagamento.toString() + solicitante.toString() + cuponDeconto;
    }

}
