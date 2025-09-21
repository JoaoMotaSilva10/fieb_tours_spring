package fieb.tours.controller;

import fieb.tours.dto.ReservaDTO;
import fieb.tours.model.Aluno;
import fieb.tours.model.Passeio;
import fieb.tours.model.Reserva;
import fieb.tours.repository.AlunoRepository;
import fieb.tours.repository.PasseioRepository;
import fieb.tours.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PasseioRepository passeioRepository;

    // Listar todas as reservas
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Criar uma nova reserva
    @PostMapping
    public Reserva createReserva(@RequestBody ReservaDTO reservaDTO) {

        // Pega o aluno pelo RM enviado pelo app
        Aluno aluno = alunoRepository.findByRm(reservaDTO.getAlunoRm())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Pega o passeio selecionado
        Passeio passeio = passeioRepository.findById(reservaDTO.getPasseioId())
                .orElseThrow(() -> new RuntimeException("Passeio não encontrado"));

        // Cria a reserva
        Reserva reserva = new Reserva();
        reserva.setNome(aluno.getNome());
        reserva.setTurma(aluno.getTurma());
        reserva.setPasseio(passeio.getNome());
        reserva.setStatus("nao-pago");

        return reservaRepository.save(reserva);
    }

    // Atualizar reserva existente
    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com id " + id));

        reserva.setPasseio(reservaDetails.getPasseio());
        reserva.setStatus(reservaDetails.getStatus());

        return reservaRepository.save(reserva);
    }

    // Deletar reserva
    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com id " + id));

        reservaRepository.delete(reserva);
    }
    
}
