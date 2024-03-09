package edu.eci.cvds.lab05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class GuessController {
    private int prize = 100000;
    private int secretNumber;

    @GetMapping("/guess")
    public String showGuessForm(Model model) {
        // Reset the game
        prize = 100000;
        secretNumber = new Random().nextInt(10) + 1;
        model.addAttribute("prize", prize);
        System.out.println(secretNumber);
        return "guess";
    }

    @PostMapping("/guess")
    public String processGuess(@RequestParam("number") int number, Model model) {
        if (number == secretNumber) {
            model.addAttribute("message", "Congratulations! You won $" + prize);
            model.addAttribute("prize", prize);
        } else {
            model.addAttribute("message", "Sorry, incorrect guess!");
            secretNumber = new Random().nextInt(10) + 1;
            System.out.println("Secr 1: " + secretNumber);
            prize -= 10000;
            if (prize < 0) {
                prize = 0;
            }
            model.addAttribute("prize", prize);
            System.out.println("Prize: " + prize);
        }
        return "guess";
    }

    @GetMapping("/reset")
    public String reset() {
        prize = 100000;
        secretNumber = new Random().nextInt(10) + 1;
        System.out.println("Secr 2: " + secretNumber);
        return "redirect:/guess";
    }
}

