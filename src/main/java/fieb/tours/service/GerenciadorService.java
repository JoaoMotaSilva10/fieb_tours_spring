package fieb.tours.service;

import fieb.tours.model.Gerenciador;
import fieb.tours.repository.GerenciadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenciadorService {

    private final GerenciadorRepository repository;

    public GerenciadorService(GerenciadorRepository repository) {
        this.repository = repository;
    }

    // Registrar novo gerenciador
    public Gerenciador registrar(Gerenciador g) {
        // Converte senha para Base64 antes de salvar
        g.setSenhaBase64(java.util.Base64.getEncoder().encodeToString(g.getSenhaBase64().getBytes()));
        return repository.save(g);
    }

    // Atualizar gerenciador
    public Gerenciador atualizar(Long id, Gerenciador gAtualizado) {
        Gerenciador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerenciador não encontrado"));

        existente.setNome(gAtualizado.getNome());
        existente.setUnidade(gAtualizado.getUnidade());
        existente.setEmail(gAtualizado.getEmail());
        existente.setSenhaBase64(java.util.Base64.getEncoder().encodeToString(gAtualizado.getSenhaBase64().getBytes()));

        return repository.save(existente);
    }

    // Deletar
    public void deletar(Long id) {
        if (!repository.existsById(id)) throw new RuntimeException("Gerenciador não encontrado");
        repository.deleteById(id);
    }

    // Listar todos
    public List<Gerenciador> listarTodos() {
        return repository.findAll();
    }

    // Autenticação pelo email e senha
    public Optional<Gerenciador> autenticar(String email, String senha) {
        String senhaBase64 = java.util.Base64.getEncoder().encodeToString(senha.getBytes());
        return repository.findByEmail(email)
                .filter(g -> g.getSenhaBase64().equals(senhaBase64));
    }
}
