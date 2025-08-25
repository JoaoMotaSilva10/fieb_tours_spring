package fieb.tours.controller;

import fieb.tours.model.Avaliacao;
import fieb.tours.service.AvaliacaoService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes")
@CrossOrigin("*")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Avaliacao> listarTodas() {
        return avaliacaoService.listarTodas();
    }

    @GetMapping("/passeio/{passeioId}")
    public List<Avaliacao> listarPorPasseio(@PathVariable Long passeioId) {
        return avaliacaoService.listarPorPasseio(passeioId);
    }

    @GetMapping("/passeio/{passeioId}/media")
    public Double mediaPorPasseio(@PathVariable Long passeioId) {
        return avaliacaoService.calcularMediaPorPasseio(passeioId);
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Avaliacao> listarPorAluno(@PathVariable Long alunoId) {
        return avaliacaoService.listarPorAluno(alunoId);
    }

    @PostMapping
    public Avaliacao criar(@Valid @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvar(avaliacao);
    }

    @GetMapping("/{id}")
    public Optional<Avaliacao> buscarPorId(@PathVariable Long id) {
        return avaliacaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        avaliacaoService.deletar(id);
    }
}
