package fieb.tours.repository;

import fieb.tours.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    // Lista todas avaliações de um passeio específico
    List<Avaliacao> findByPasseioId(Long passeioId);

    // Lista todas avaliações de um aluno específico
    List<Avaliacao> findByAlunoId(Long alunoId);

    // Calcula a média das notas de um passeio
    @Query("SELECT AVG(a.nota) FROM Avaliacao a WHERE a.passeioId = :passeioId")
    Double calcularMediaPorPasseio(Long passeioId);
}
