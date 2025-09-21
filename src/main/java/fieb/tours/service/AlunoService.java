package fieb.tours.service;

import fieb.tours.model.Aluno;
import fieb.tours.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Registrar um novo aluno
    public Aluno registrar(Aluno aluno) {
        System.out.println("[AlunoService] Registrando aluno: " + aluno);

        // Converter a senha para Base64 antes de salvar
        String senhaBase64 = Base64.getEncoder().encodeToString(aluno.getSenhaBase64().getBytes());
        aluno.setSenhaBase64(senhaBase64);

        return repository.save(aluno);
    }

    // Atualizar aluno existente
    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        System.out.println("[AlunoService] Atualizando aluno ID: " + id);
        Aluno existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        existente.setNome(alunoAtualizado.getNome());
        existente.setRm(alunoAtualizado.getRm());
        existente.setTurma(alunoAtualizado.getTurma());
        existente.setNumeroChamada(alunoAtualizado.getNumeroChamada());

        // Atualizar senha em Base64
        String senhaBase64 = Base64.getEncoder().encodeToString(alunoAtualizado.getSenhaBase64().getBytes());
        existente.setSenhaBase64(senhaBase64);

        return repository.save(existente);
    }

    // Deletar aluno
    public void deletar(Long id) {
        System.out.println("[AlunoService] Deletando aluno ID: " + id);
        boolean exists = repository.existsById(id);
        if (!exists) {
            System.out.println("[AlunoService] Aluno ID " + id + " não existe!");
            throw new RuntimeException("Aluno não encontrado");
        }
        repository.deleteById(id);
        System.out.println("[AlunoService] Aluno deletado com sucesso!");
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Autenticar aluno (senha já em Base64)
    public Optional<Aluno> autenticar(String rm, String senhaBase64) {
        return repository.findByRmAndSenhaBase64(rm, senhaBase64);
    }

    // Autenticar aluno usando senha em texto normal (converte para Base64 antes de comparar)
    public Optional<Aluno> autenticarPorSenhaTexto(String rm, String senhaTexto) {
        String senhaBase64 = Base64.getEncoder().encodeToString(senhaTexto.getBytes());
        return repository.findByRmAndSenhaBase64(rm, senhaBase64);
    }
}
