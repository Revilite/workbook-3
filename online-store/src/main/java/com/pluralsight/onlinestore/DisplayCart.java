package com.pluralsight.onlinestore;

import java.util.HashMap;
import java.util.Scanner;

public class DisplayCart {
    private static Scanner scan = new Scanner(System.in);

    public static HashMap[] displayCart(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        for (String key : cart.keySet()) {
            System.out.println(cart.get(key));
        }
        System.out.println("""
                Checkout       (C)
                Remove Product (R)
                Go Back        (B)
                """);
        String userInput = scan.nextLine();
        while (!userInput.equalsIgnoreCase("b")) {
            if (userInput.equalsIgnoreCase("c")) {
                System.out.println("I dont feel like doing this right now :(");
            } else if (userInput.equalsIgnoreCase("r")) {
                System.out.println("Enter the SKU of the item you want to remove");
                String userSKU = scan.nextLine();
                if (cart.containsKey(userSKU)) {
                    cart.remove(userSKU);
                    inventory.put(userSKU, cart.get(userSKU));
                    System.out.println("Item removed from cart!");
                }
                else{
                    System.out.println("Something Went Wrong, But we dont know why!");
                    Thread.sleep(1000);
                    break;
                }
            }
        }


        return new HashMap[]{inventory, cart};
    }
}
