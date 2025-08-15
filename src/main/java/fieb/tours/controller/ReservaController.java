package fieb.tours.controller;

import fieb.tours.model.Reserva;
import fieb.tours.repository.ReservaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin("*")
public class ReservaController {

    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @PostMapping
    public Reserva reservar(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }
}
