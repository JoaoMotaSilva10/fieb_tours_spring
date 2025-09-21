package fieb.tours.dto;

public class ReservaDTO {

    private String alunoRm;   // RM do aluno
    private Long passeioId;   // ID do passeio

    // Construtor vazio
    public ReservaDTO() {
    }

    // Getters e Setters
    public String getAlunoRm() {
        return alunoRm;
    }

    public void setAlunoRm(String alunoRm) {
        this.alunoRm = alunoRm;
    }

    public Long getPasseioId() {
        return passeioId;
    }

    public void setPasseioId(Long passeioId) {
        this.passeioId = passeioId;
    }
}
