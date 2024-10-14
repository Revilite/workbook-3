package com.pluralsight.application;

import java.io.IOException;
import java.util.Scanner;

public class MainScreen {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                ================
                    Welcome!
                ================  
                """);
        boolean mainLoop = true;

        while (mainLoop) {
            System.out.println("""
                    Which action would you like to  do?
                    
                    Add Deposit         (1)
                    Make a Payment      (2)
                    Ledger              (3)
                    Exit                (4)
                    """);
            String mainChoice = scan.nextLine();

            switch (mainChoice) {
                case "1": {
                    System.out.println("Input your deposit information");
                    String depositInfo = scan.nextLine();
                    try {
                        AddDeposit.deposit(depositInfo);
                    } catch (IOException e) {
                        System.out.println("Unable to deposit information :(");
                    }
                }
                default:{
                    System.out.println("Please choose one of the options :)");
                }
            }

        }

    }

}
