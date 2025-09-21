package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "passeios", schema = "dbo")
public class Passeio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataPasseio;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String horaSaida;

    @Column(nullable = false)
    private String horaChegada;

    @Column(nullable = false)
    private LocalDate dataInicioRecebimento;

    @Column(nullable = false)
    private LocalDate dataFinalRecebimento;

    @Column(nullable = false)
    private String statusPasseio;

    @Column(nullable = false)
    private java.time.LocalDate dataCadastro;
}
