package com.pluralsight.onlinestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DisplayCart {

    public static void displayCart(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String reset = "\033[1;0m";
        String blueForeground = "\033[1;34m";
        String redForeground = "\033[1;31m";
        // testing remove later


        String userInput = "";
        while (!userInput.equalsIgnoreCase("3")) {
            double totalPrice = 0;
            for (Product item : cart.values()) {
                System.out.printf("""
                        \033[1;31m%-33s    \033[1;34m     $%6.2f     \033[1;0m
                        """, item.getProductName(), item.getPrice());
                totalPrice += item.getPrice();
            }
            if (cart.size() == 0) {
                System.out.println(redForeground + "Theres nothing in your cart!" + reset);
            } else {
                System.out.printf("\n" + redForeground + "%-38s" + blueForeground + "    $%6.2f\n\n" + reset, "Total Price", totalPrice);
            }
            System.out.print("""
                    Checkout       (1)
                    Remove Product (2)
                    Go Back        (3)
                    """);
            userInput = scan.nextLine();


            if (userInput.equalsIgnoreCase("1")) {
                CheckOut.mainCheckoutScreen(cart, totalPrice);
                return;
            } else if (userInput.equalsIgnoreCase("2")) {
                String isUserFinished = "n";
                if (cart.size() == 0) {
                    System.out.println("\nYou can't remove what you don't have!");
                    break;
                }
                do {
                    ArrayList<Product> tempList = new ArrayList<>();
                    System.out.println("Enter the name of the product you want to remove from your cart");
                    String productName = scan.nextLine();
                    for (Product item : cart.values()) {
                        if (item.getProductName().equalsIgnoreCase(productName)) {
                            inventory.put(item.getSku(), item);
                            tempList.add(item);
                        }
                        if (cart.size() == 0) {
                            System.out.println("Your cart is empty!");
                            return;
                        }
                    }
                    if (tempList.isEmpty()) {
                        System.out.println("That's not in your cart!");
                    } else {
                        cart.remove(tempList.get(0).getSku());
                        System.out.println("Are you done removing items? (y/n)");
                        isUserFinished = scan.nextLine();
                        if (!isUserFinished.equalsIgnoreCase("y") && !isUserFinished.equalsIgnoreCase("n")) {
                            System.out.println("That is not y or n, returning to items");
                            Thread.sleep(1000);
                        }
                    }
                } while (isUserFinished.equalsIgnoreCase("n"));
                break;
            } else if (userInput.equals("3")) {
                return;
            } else {
                System.out.println("Please choose one of the options");
                Thread.sleep(1000);
            }
        }
    }
}
