package fieb.tours.controller;

import fieb.tours.model.Aluno;
import fieb.tours.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*") // Liberar para o Flutter/Web
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Registrar um novo aluno
    @PostMapping("/registrar")
    public Aluno registrar(@RequestBody Aluno aluno) {
        return alunoService.registrar(aluno);
    }

    // Login agora recebe JSON com rm e senhaBase64
    @PostMapping("/login")
    public Aluno login(@RequestBody Aluno aluno) {
        return alunoService.autenticar(aluno.getRm(), aluno.getSenhaBase64())
                .map(a -> {
                    a.setSenhaBase64(null); // não expor senha
                    return a;
                })
                .orElse(null); // retorna null se não autenticado
    }

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }
}
