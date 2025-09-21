package fieb.tours.repository;

import fieb.tours.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByRm(String rm); // já usamos para reservas

    // Adicione este método para autenticação
    Optional<Aluno> findByRmAndSenhaBase64(String rm, String senhaBase64);
}
