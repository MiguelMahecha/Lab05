package edu.eci.cvds.lab05.controller;

import edu.eci.cvds.lab05.model.GameModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class GuessController {
    private GameModel gameModel;

    @GetMapping("/guess")
    public String showGuessForm(Model model) {
        if (gameModel == null) gameModel = new GameModel();
        model.addAttribute("prize", gameModel.getPrize());
        return "guess";
    }

    @PostMapping("/guess")
    public String processGuess(@RequestParam("number") int number, Model model) {
        if (gameModel.isCorrect(number)) {
            model.addAttribute("message", "Congratulations! You won $" + gameModel.getPrize());
            model.addAttribute("prize", gameModel.getPrize());
        }
        else {
            model.addAttribute("message", "Sorry, incorrect guess!");
            gameModel.genNewSecretNumber();
            gameModel.reducePrice();
            model.addAttribute("prize", gameModel.getPrize());
            System.out.println("Prize: " + gameModel.getPrize());
        }
        return "guess";
    }

    @GetMapping("/reset")
    public String reset() {
        gameModel.reset();
        return "redirect:/guess";
    }
}

