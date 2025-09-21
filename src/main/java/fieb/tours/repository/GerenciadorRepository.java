package fieb.tours.repository;

import fieb.tours.model.Gerenciador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GerenciadorRepository extends JpaRepository<Gerenciador, Long> {

    Optional<Gerenciador> findByEmail(String email); // Busca pelo email
}
