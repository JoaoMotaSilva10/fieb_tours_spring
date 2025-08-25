package fieb.tours.controller;

import fieb.tours.model.Reserva;
import fieb.tours.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin("*")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public Reserva reservar(@RequestBody Reserva reserva) {
        return reservaService.reservar(reserva);
    }

    @PutMapping("/{id}/cancelar")
    public Reserva cancelar(@PathVariable Long id) {
        return reservaService.cancelar(id);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarTodas();
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Reserva> listarPorAluno(@PathVariable Long alunoId) {
        return reservaService.listarPorAluno(alunoId);
    }

    @GetMapping("/passeio/{passeioId}")
    public List<Reserva> listarPorPasseio(@PathVariable Long passeioId) {
        return reservaService.listarPorPasseio(passeioId);
    }
}
