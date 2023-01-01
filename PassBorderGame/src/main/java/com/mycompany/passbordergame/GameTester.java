package com.mycompany.passbordergame;

import java.util.Scanner;
public class GameTester {
    public static void main(String[] args) {
        System.out.println("Enter a difficulty level (1-3)");
        Scanner input = new Scanner(System.in);
        int difficulty = input.nextInt();
        Game game = new Game(difficulty);
        game.play();
    }
}
