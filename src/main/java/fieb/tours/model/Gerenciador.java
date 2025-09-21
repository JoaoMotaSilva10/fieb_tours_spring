package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gerenciadores", schema = "dbo")
public class Gerenciador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senhaBase64;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false, unique = true)
    private String email; // Novo campo
}
