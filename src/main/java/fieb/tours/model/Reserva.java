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

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "passeio_id", nullable = false)
    private Passeios passeio;

    @Column(nullable = false)
    private String status = "CONFIRMADA"; // Status padrão
}
