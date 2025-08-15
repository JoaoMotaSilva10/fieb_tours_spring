package fieb.tours.controller;

import fieb.tours.model.Aluno;
import fieb.tours.service.AlunoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*") // Liberar para o Flutter
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/registrar")
    public Aluno registrar(@RequestBody Aluno aluno) {
        return alunoService.registrar(aluno);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String rm, @RequestParam String senha) {
        return alunoService.autenticar(rm, senha);
    }
}
