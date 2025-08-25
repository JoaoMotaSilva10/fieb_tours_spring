package fieb.tours.service;

import fieb.tours.model.Aluno;
import fieb.tours.model.Passeios;
import fieb.tours.model.Reserva;
import fieb.tours.repository.AlunoRepository;
import fieb.tours.repository.PasseioRepository;
import fieb.tours.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final AlunoRepository alunoRepository;
    private final PasseioRepository passeioRepository;

    public ReservaService(ReservaRepository reservaRepository,
                          AlunoRepository alunoRepository,
                          PasseioRepository passeioRepository) {
        this.reservaRepository = reservaRepository;
        this.alunoRepository = alunoRepository;
        this.passeioRepository = passeioRepository;
    }

    public Reserva reservarPorIds(Long alunoId, Long passeioId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Passeios passeio = passeioRepository.findById(passeioId)
                .orElseThrow(() -> new RuntimeException("Passeio não encontrado"));

        boolean jaExiste = reservaRepository
                .findByAluno_IdAndPasseio_Id(alunoId, passeioId)
                .isPresent();

        if (jaExiste) {
            throw new RuntimeException("Aluno já possui reserva para este passeio!");
        }

        Reserva reserva = new Reserva();
        reserva.setAluno(aluno);
        reserva.setPasseio(passeio);
        reserva.setStatus("CONFIRMADA");

        return reservaRepository.save(reserva);
    }

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
        return reservaRepository.findByAluno_Id(alunoId);
    }

    public List<Reserva> listarPorPasseio(Long passeioId) {
        return reservaRepository.findByPasseio_Id(passeioId);
    }
}
