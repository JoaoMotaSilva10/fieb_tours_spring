package fieb.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passeios")
public class Passeio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String imagem; // URL ou caminho da imagem
}