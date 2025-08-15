package fieb.tours.repository;

import fieb.tours.model.Passeio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasseioRepository extends JpaRepository<Passeio, Long> {
}