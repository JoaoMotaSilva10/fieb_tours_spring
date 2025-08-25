package fieb.tours.service;

import fieb.tours.model.Avaliacao;
import fieb.tours.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> listarPorPasseio(Long passeioId) {
        return avaliacaoRepository.findByPasseioId(passeioId);
    }

    public List<Avaliacao> listarPorAluno(Long alunoId) {
        return avaliacaoRepository.findByAlunoId(alunoId);
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Optional<Avaliacao> buscarPorId(Long id) {
        return avaliacaoRepository.findById(id);
    }

    public void deletar(Long id) {
        avaliacaoRepository.deleteById(id);
    }

    public Double calcularMediaPorPasseio(Long passeioId) {
        return avaliacaoRepository.calcularMediaPorPasseio(passeioId);
    }
}
