package edu.eci.cvds.lab05.model;

import java.util.Random;

public class GameModel {
    private int prize;
    private int secretNumber;

    public GameModel() {
        prize = 100000;
        secretNumber = new Random().nextInt(10) + 1;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public boolean isCorrect(int userGuess) {
        return userGuess == secretNumber;
    }

    public void genNewSecretNumber() {
        secretNumber = new Random().nextInt(10) + 1;
    }

    public void reducePrice() {
        prize -= 10000;
        if (prize < 0) {
            prize = 0;
        }
    }

    public void reset() {
        prize = 100000;
        genNewSecretNumber();
    }
}
