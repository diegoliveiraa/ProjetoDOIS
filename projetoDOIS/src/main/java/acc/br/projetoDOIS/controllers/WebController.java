package acc.br.projetoDOIS.controllers;

import acc.br.projetoDOIS.dtos.ScoreDTO;
import acc.br.projetoDOIS.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/teste")
    public String teste(@RequestParam(name = "escolha") String escolha, Model model) {
        ScoreDTO scoreDTO = scoreService.scoreUpdater(escolha);

        model.addAttribute("saida", scoreService.getResult(escolha));
        model.addAttribute("aEscolha", escolha);
        model.addAttribute("placar", scoreDTO);

        return "resultado";
    }

}