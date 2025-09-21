package fieb.tours.controller;

import fieb.tours.model.Passeio;
import fieb.tours.service.PasseioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passeios")
@CrossOrigin("*")
public class PasseioController {

    private final PasseioService passeioService;

    public PasseioController(PasseioService passeioService) {
        this.passeioService = passeioService;
    }

    @GetMapping
    public List<Passeio> listarTodos() {
        return passeioService.listarTodos();
    }

    @PostMapping("/registrar")
    public Passeio registrar(@RequestBody Passeio passeio) {
        return passeioService.registrar(passeio);
    }

    @PutMapping("/{id}")
    public Passeio atualizar(@PathVariable Long id, @RequestBody Passeio passeio) {
        return passeioService.atualizar(id, passeio);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        passeioService.deletar(id);
    }
}
