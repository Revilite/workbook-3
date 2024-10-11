package com.pluralsight.onlinestore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class CheckOut {

    public static void toCheckOut(HashMap<String, Product> cart, double totalPrice, double cash) {
        LocalDateTime timeRightNow = LocalDateTime.now();
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        double change = cash - totalPrice;

        System.out.printf("Order Date: %-30s\n", formattedTime.format(timeRightNow));
        for (Product item : cart.values()) {
            System.out.printf("%-33s  $%-10.2f\n", item.getProductName(), item.getPrice());
        }
        System.out.printf("\nTotal:         $%7.2f\n", totalPrice);
        System.out.printf("Amount Paid:   $%7.2f\n", cash);
        System.out.printf("Change Given:  $%7.2f\n", change);

        cart.clear();
    }

    public static void toPrintReceipt(HashMap<String, Product> cart, double totalPrice, double cash) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter fileName = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
        DateTimeFormatter currentFormattedTime = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm");
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/" + fileName.format(currentTime) + ".txt"));
        double change = cash - totalPrice;

        StringBuilder sb = new StringBuilder(String.format("Order Date: %-30s", currentFormattedTime.format(currentTime)));
        for (Product item : cart.values()) {
            sb.append(String.format("\n%-33s  $%-10.2f", item.getProductName(), item.getPrice()));
        }
        sb.append(String.format("\n\nTotal:         $%7.2f\n", totalPrice));
        sb.append(String.format("Amount Paid:   $%7.2f\n", cash));
        sb.append(String.format("Change Given:  $%7.2f\n", change));

        buffWrite.write(sb.toString());
        buffWrite.close();
    }


    public static void mainCheckoutScreen(HashMap<String, Product> cart, double totalPrice) {
        Scanner scan = new Scanner(System.in);
        String redForeground = "\033[1;31m";
        String reset = "\033[1;0m";

        String isCheckingOut;
        double cashDouble = 0;
        do {
            System.out.print("Enter your payment $");
            String cash = scan.nextLine();

            try {
                cashDouble = Double.parseDouble(cash);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            if (cashDouble < totalPrice) {
                System.out.println(redForeground + "You don't have enough funds for all your items, broke" + reset);
                break;
            } else {
//                toCheckOut(cart, totalPrice, cashDouble);
                try {
                    toPrintReceipt(cart, totalPrice, cashDouble);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }


        } while (isCheckingOut.equalsIgnoreCase("y"));


    }
}
