package fieb.tours.controller;

import fieb.tours.model.Gerenciador;
import fieb.tours.service.GerenciadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerenciadores")
@CrossOrigin("*")
public class GerenciadorController {

    private final GerenciadorService service;

    public GerenciadorController(GerenciadorService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public Gerenciador registrar(@RequestBody Gerenciador g) {
        return service.registrar(g);
    }

    @PutMapping("/{id}")
    public Gerenciador atualizar(@PathVariable Long id, @RequestBody Gerenciador g) {
        return service.atualizar(id, g);
    }

    @GetMapping
    public List<Gerenciador> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping("/login")
    public Gerenciador login(@RequestBody Gerenciador g) {
        return service.autenticar(g.getEmail(), g.getSenhaBase64())
                .map(ger -> {
                    ger.setSenhaBase64(null); // não retorna senha
                    return ger;
                })
                .orElse(null);
    }
}
