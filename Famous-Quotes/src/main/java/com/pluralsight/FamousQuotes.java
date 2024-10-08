package com.pluralsight;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String[] quotes = {"I'm gonna make him an offer he can't refuse - The Godfather", "It rubs the lotion on its skin or else it gets the hose again - The silence of the lambs", "May the force be with you - Star Wars", "Life is like a box of chocolates. You never know what you\'re going to get - Forrest Gump",
                "I\'ll be back - Terminator", "To infinity and beyond! - Toy Story", "You can't handle the truth! - A few good men", "I see dead people - The sixth sense", "Just keep swimming - finding nemo", "You had me at hello - jerry maguire"};
        String mainLoop = "y";

        while (mainLoop.equals("y")) {
            System.out.println("Would you like to choose your quote or get a random one?  (C/R)");
            String quoteChoice = scan.nextLine().toLowerCase();

            if (quoteChoice.equals("c")) {
                try {
                    System.out.println("Pick a quote between 1-10");
                    int userNumber = scan.nextInt();
                    scan.nextLine();

                    System.out.println(quotes[userNumber - 1]);
                } catch (InputMismatchException e) {
                    System.out.println("Thats not a number!");
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("You picked a number out of bounds!");
                    e.getStackTrace();
                }
            } else if (quoteChoice.equals("r")) {
                System.out.println(quotes[rand.nextInt(10)]);
            } else {
                System.out.println("That was not one of the choices!");
            }

            System.out.println("Would you like to try again?  (Y/N)");
            mainLoop = scan.nextLine().toLowerCase();


            if (!mainLoop.equals("y") && !mainLoop.equals("n")) {
                System.out.println("Wrong answer, exiting program ^_^");
            }

        }


    }
}
