package fieb.tours.service;

import fieb.tours.model.Passeio;
import fieb.tours.repository.PasseioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasseioService {

    private final PasseioRepository repository;

    public PasseioService(PasseioRepository repository) {
        this.repository = repository;
    }

    public Passeio registrar(Passeio passeio) {
        return repository.save(passeio);
    }

    public Passeio atualizar(Long id, Passeio passeioAtualizado) {
        Passeio existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passeio não encontrado"));

        existente.setNome(passeioAtualizado.getNome());
        existente.setDescricao(passeioAtualizado.getDescricao());
        existente.setDataPasseio(passeioAtualizado.getDataPasseio());
        existente.setPreco(passeioAtualizado.getPreco());
        existente.setHoraSaida(passeioAtualizado.getHoraSaida());
        existente.setHoraChegada(passeioAtualizado.getHoraChegada());
        existente.setDataInicioRecebimento(passeioAtualizado.getDataInicioRecebimento());
        existente.setDataFinalRecebimento(passeioAtualizado.getDataFinalRecebimento());
        existente.setDataCadastro(passeioAtualizado.getDataCadastro());
        existente.setStatusPasseio(passeioAtualizado.getStatusPasseio());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) throw new RuntimeException("Passeio não encontrado");
        repository.deleteById(id);
    }

    public List<Passeio> listarTodos() {
        return repository.findAll();
    }
}
