package com.pluralsight.onlinestore;

import java.util.HashMap;
import java.util.Scanner;

public class DisplayAllProducts {
    //Main method
    public static void displayAllProducts(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String productPageChoice = "";
        while (!productPageChoice.equals("b")) {
            for (String key : inventory.keySet()) {
                System.out.println(inventory.get(key));
            }
            System.out.print("""
                    
                    Search for a item        (1)
                    Add an item to your cart (2)
                    Go back to the main page (3)
                    """);
            productPageChoice = scan.nextLine().toLowerCase();
            if (productPageChoice.equalsIgnoreCase("1")) {
                SearchProducts.searchItem(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("2")) {
                SearchProducts.addToCart(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("3")) {
                break;
            } else {
                System.out.println("Please choose one of the options");
                Thread.sleep(1000);
            }

        }
    }
}
