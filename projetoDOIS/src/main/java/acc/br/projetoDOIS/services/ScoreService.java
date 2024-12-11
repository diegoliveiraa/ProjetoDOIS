package acc.br.projetoDOIS.services;

import acc.br.projetoDOIS.dtos.ScoreDTO;
import acc.br.projetoDOIS.entity.Score;
import acc.br.projetoDOIS.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public ScoreDTO scoreUpdater(String escolha) {
        Score score = scoreRepository.findById(1).orElse(new Score(0, 0, 0));

        switch (escolha.toLowerCase()) {
            case "papel":
                score.setVitorias(score.getVitorias() + 1);
                break;
            case "tesoura":
                score.setDerrotas(score.getDerrotas() + 1);
                break;
            case "pedra":
                score.setEmpates(score.getEmpates() + 1);
                break;
        }

        scoreRepository.save(score);
        return new ScoreDTO(score.getVitorias(), score.getDerrotas(), score.getEmpates());
    }

    public String getResult(String escolha) {
        switch (escolha.toLowerCase()) {
            case "papel": return "ganhou";
            case "tesoura": return "perdeu";
            case "pedra": return "empatou";
            default: return "escolha inválida";
        }
    }
}
