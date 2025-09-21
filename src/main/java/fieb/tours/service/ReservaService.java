package fieb.tours.service;

import fieb.tours.model.Aluno;
import fieb.tours.model.Passeio;
import fieb.tours.model.Reserva;
import fieb.tours.repository.AlunoRepository;
import fieb.tours.repository.PasseioRepository;
import fieb.tours.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PasseioRepository passeioRepository;

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva criarReserva(String rmAlunoLogado, Long passeioId) {
        Aluno aluno = alunoRepository.findByRm(rmAlunoLogado)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Passeio passeio = passeioRepository.findById(passeioId)
                .orElseThrow(() -> new RuntimeException("Passeio não encontrado"));

        Reserva reserva = new Reserva();
        reserva.setNome(aluno.getNome());
        reserva.setTurma(aluno.getTurma());
        reserva.setPasseio(passeio.getNome());
        reserva.setStatus("nao-pago");

        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setPasseio(reservaAtualizada.getPasseio());
        reserva.setStatus(reservaAtualizada.getStatus());

        return reservaRepository.save(reserva);
    }

    public void deletarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reservaRepository.delete(reserva);
    }
}
