package br.edu.infnet.appPetShop.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TabPagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagamentos;
    private Long cartaoCredito;
    private LocalDate dataVencimento;
    @Transient
    private int cvcCodigoSeguranca;
    private int tokenId;

    @Override
    public String toString()
    {
        return "registro de pagamento: " + tokenId;
    }
}

