package fieb.tours.repository;

import fieb.tours.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Pode adicionar métodos customizados se precisar
}
