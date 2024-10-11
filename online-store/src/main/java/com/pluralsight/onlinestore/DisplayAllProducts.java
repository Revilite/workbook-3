package com.pluralsight.onlinestore;

import java.util.HashMap;
import java.util.Scanner;

public class DisplayAllProducts {
    private static Scanner scan = new Scanner(System.in);



    //Main method
    public static void displayAllProducts(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        String productPageChoice = "";
        while (!productPageChoice.equals("b")) {
            for (String key : inventory.keySet()) {
                System.out.println(inventory.get(key));
            }
            System.out.println("""
                    Search for a item        (S)
                    Add an item to your cart (C)
                    Go back to the main page (B)
                    """);
            productPageChoice = scan.nextLine().toLowerCase();
            if (productPageChoice.equalsIgnoreCase("s")) {
                SearchProducts.searchItem(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("c")) {
                SearchProducts.addToCart(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("That's not a good choice");
                Thread.sleep(1000);
            }

        }
    }
}
