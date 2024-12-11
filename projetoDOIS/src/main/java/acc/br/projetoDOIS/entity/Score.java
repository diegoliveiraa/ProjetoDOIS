package acc.br.projetoDOIS.entity;

import acc.br.projetoDOIS.dtos.ScoreDTO;
import org.springframework.data.annotation.Id;

public class Score {

    @Id
    private Integer id;
    private int vitorias, derrotas, empates;

    public Score(int empates, int vitorias, int derrotas) {
        this.empates = empates;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public Score() {
    }

    public Score(ScoreDTO data){
        this.vitorias = data.vitorias();
        this.derrotas = data.derrotas();
        this.empates = data.empates();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                '}';
    }
}
