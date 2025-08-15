package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rm; // Identificação

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String turma;

    @Column(nullable = false)
    private Integer numeroChamada;

    @Column(nullable = false)
    private String senhaBase64; // Armazena senha codificada
}
