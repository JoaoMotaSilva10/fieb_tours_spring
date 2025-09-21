package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas", schema = "dbo")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;        // nome do aluno

    @Column(nullable = false)
    private String turma;       // turma do aluno

    @Column(nullable = false)
    private String passeio;     // nome do passeio

    @Column(nullable = false)
    private String status = "nao-pago"; // status da reserva
}
