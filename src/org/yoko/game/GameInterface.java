package org.yoko.game;

import java.util.Random;
import java.util.Scanner;

public class GameInterface {

    public static void main(String[] args) {

        System.out.println("Welcome to the game");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:   ");
        String name = scanner.next();

        System.out.println("Hello " + name);

        System.out.println("Can we start a game " + name + "?");
        System.out.println("\t1.   Yes");
        System.out.println("\t2.   No");

        int beginAnswer = scanner.nextInt();

        while (beginAnswer != 1){
            System.out.println("Can we start a game " + name + "?");
            System.out.println("\t1.   Yes");
            System.out.println("\t2.   No");

            beginAnswer = scanner.nextInt();
        }

        Random random = new Random();
        int x = random.nextInt(20);
        System.out.println("Please guess a number:   ");
        int userInput = scanner.nextInt();

        int timesTried = 0;
        boolean hasWon = false;
        boolean shouldFinish = false;

        while (!shouldFinish){
            timesTried++;

            if (timesTried < 5){
                if (userInput == x) {
                    hasWon = true;
                    shouldFinish = true;
                }else if (userInput > x){
                    System.out.println("Guess lower");
                    userInput = scanner.nextInt();
                }else{
                    System.out.println("Guess higher");
                    userInput = scanner.nextInt();
                }

            }else {
                shouldFinish = true;
            }
        }
        if (hasWon){
            System.out.println("Congratulations ! you have guessed in your  " + timesTried + " guess.");
        }else {
            System.out.println("Game over!");
            System.out.println("The number was: " + x);
        }
    }
}
