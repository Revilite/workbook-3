package com.pluralsight.onlinestore;

import java.util.HashMap;
import java.util.Scanner;

public class DisplayAllProducts {
    private static Scanner scan = new Scanner(System.in);

    public static void searchByDepartment(HashMap<String, Product> inventory, HashMap<String, Product> cart) {
        boolean departmentSearch = true;
        while(departmentSearch){
            System.out.println("What department are you looking for?");
            String department = scan.nextLine();
            if(inventory.containsValue(department)){
                System.out.println("Hello  WOrld");
            }
        }
    }

    public static void searchBySKU(HashMap<String, Product> inventory, HashMap<String, Product> cart) {
        boolean invalidSKU = true;
        while (invalidSKU) {
            System.out.println("What is the SKU of the item your looking for? (type \"x\" to exit)");
            String userSKU = scan.nextLine().toUpperCase();
            if (userSKU.equalsIgnoreCase("x")) {
                return;
            }
            if (inventory.containsKey(userSKU)) {
                invalidSKU = false;
            }
            if (invalidSKU) {
                System.out.println("Invalid SKU");
            } else {
                System.out.println(inventory.get(userSKU));
            }
            //Gets user input if they want to save this item or not
            System.out.println("Would you like to add this item to your cart? (Y/N)");
            String addItemFromSearch = scan.nextLine().toLowerCase();

            //Adds item and removes from inventory
            if (addItemFromSearch.equals("y")) {
                cart.put(userSKU, inventory.get(userSKU));
                inventory.remove(userSKU);
                System.out.println("Added Successfully!");
            } else {
                System.out.println("That isn't a choice");

            }
            try {
                Thread.sleep(1000);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void searchItem(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        System.out.println("""
               What would you like to search by?
               Department (D)
               Price      (P)
               Name       (N)
               SKU        (S)
                
                """);

    }

    public static void addToCart(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        boolean invalidSKU = true;
        while (invalidSKU) {
            System.out.println("Type the SKU of the item to add to the cart");
            String userSKU = scan.nextLine().toUpperCase();
            if (inventory.containsKey(userSKU)) {
                cart.put(userSKU, inventory.get(userSKU));
                inventory.remove(userSKU);
                invalidSKU = false;
            }
            if (invalidSKU) {
                System.out.println("Invalid SKU");
            } else {
                System.out.println("Added Successfully!");
                Thread.sleep(1000);
            }
        }
    }

    //Main method
    public static HashMap[] displayAllProducts(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
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
                searchItem(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("c")) {
                addToCart(inventory, cart);
            } else if (productPageChoice.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("That's not a good choice");
                Thread.sleep(1000);
            }

        }

        return new HashMap[]{inventory, cart};
    }
}
