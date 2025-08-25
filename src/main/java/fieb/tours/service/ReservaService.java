package fieb.tours.service;

import fieb.tours.model.Reserva;
import fieb.tours.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Criar nova reserva com validação
    public Reserva reservar(Reserva reserva) {
        boolean jaExiste = reservaRepository
                .findByAlunoIdAndPasseioId(reserva.getAluno().getId(), reserva.getPasseio().getId())
                .isPresent();

        if (jaExiste) {
            throw new RuntimeException("Aluno já possui reserva para este passeio!");
        }

        reserva.setStatus("CONFIRMADA");
        return reservaRepository.save(reserva);
    }

    // Cancelar reserva
    public Reserva cancelar(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus("CANCELADA");
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public List<Reserva> listarPorAluno(Long alunoId) {
        return reservaRepository.findByAlunoId(alunoId);
    }

    public List<Reserva> listarPorPasseio(Long passeioId) {
        return reservaRepository.findByPasseioId(passeioId);
    }
}
