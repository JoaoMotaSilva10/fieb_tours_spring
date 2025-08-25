package fieb.tours.repository;

import fieb.tours.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Optional<Reserva> findByAlunoIdAndPasseioId(Long alunoId, Long passeioId);

    List<Reserva> findByAlunoId(Long alunoId);

    List<Reserva> findByPasseioId(Long passeioId);
}
