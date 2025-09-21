package fieb.tours.controller;

import fieb.tours.model.Aluno;
import fieb.tours.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/registrar")
    public Aluno registrar(@RequestBody Aluno aluno) {
        System.out.println("[AlunoController] POST /registrar");
        return alunoService.registrar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        System.out.println("[AlunoController] PUT /" + id);
        return alunoService.atualizar(id, aluno);
    }

    @PostMapping("/login")
    public Aluno login(@RequestBody Aluno aluno) {
        System.out.println("[AlunoController] POST /login RM: " + aluno.getRm());
        // Autenticar usando a senha em texto normal
        return alunoService.autenticarPorSenhaTexto(aluno.getRm(), aluno.getSenhaBase64())
                .map(a -> {
                    a.setSenhaBase64(null); // não expor senha
                    return a;
                })
                .orElse(null);
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        System.out.println("[AlunoController] GET /");
        return alunoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        System.out.println("[AlunoController] DELETE /" + id);
        alunoService.deletar(id);
    }
}
