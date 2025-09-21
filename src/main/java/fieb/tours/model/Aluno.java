package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alunos", schema = "dbo")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rm;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String turma;

    @Column(nullable = false)
    private int numeroChamada;

    @Column(nullable = false)
    private String senhaBase64;
}
