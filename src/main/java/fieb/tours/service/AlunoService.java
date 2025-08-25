package fieb.tours.service;

import fieb.tours.model.Aluno;
import fieb.tours.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Registrar novo aluno (senha armazenada em Base64)
    public Aluno registrar(Aluno aluno) {
        aluno.setSenhaBase64(Base64.getEncoder().encodeToString(aluno.getSenhaBase64().getBytes()));
        return alunoRepository.save(aluno);
    }

    // Autenticar: retorna Optional<Aluno>
    public Optional<Aluno> autenticar(String rm, String senha) {
        return alunoRepository.findByRm(rm)
                .filter(aluno -> aluno.getSenhaBase64()
                        .equals(Base64.getEncoder().encodeToString(senha.getBytes())));
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }
}
