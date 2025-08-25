package fieb.tours.controller;

import fieb.tours.model.Passeios;
import fieb.tours.repository.PasseioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passeios")
@CrossOrigin("*")
public class PasseioController {

    private final PasseioRepository passeioRepository;

    public PasseioController(PasseioRepository passeioRepository) {
        this.passeioRepository = passeioRepository;
    }

    @GetMapping
    public List<Passeios> listar() {
        return passeioRepository.findAll();
    }
}
