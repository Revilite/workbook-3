package com.pluralsight.onlinestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchProducts {
    private static Scanner scan = new Scanner(System.in);

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


    public static void searchByDepartment(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        String departmentSearch = "l";
        ArrayList<Product> tempList = new ArrayList();

        while (departmentSearch.equalsIgnoreCase("l")) {
            System.out.println("What department are you looking for? (enter \"x\" to exit search)");
            String department = scan.nextLine();
            for (Product item : inventory.values()) {
                //Boolean variable ignores if statement????
                if (item.getDepartment().equalsIgnoreCase(department)) {
                    System.out.println(item);
                    tempList.add(item);
                }
            }
            if (department.equalsIgnoreCase("x")) {
                return;
            } else if (tempList.isEmpty()) {
                System.out.println("We didn't find any departments with that name!");
            } else {
                //Add a number system to buy specific items
                addToCart(inventory, cart);
                return;
            }
        }
    }

    public static void searchBySKU(HashMap<String, Product> inventory, HashMap<String, Product> cart) {
        boolean invalidSKU = true;
        // Prints twice, Have no idea why
        do {
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (invalidSKU);
    }


    public static void searchItem(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        String searchInput = "";
        while (!searchInput.equalsIgnoreCase("e")) {
            System.out.println("""
                    What would you like to search by?
                    Department (D)
                    Price      (P)
                    Name       (N)
                    SKU        (S)
                    Exit       (E)
                    """);
            searchInput = scan.nextLine().toLowerCase();

            switch (searchInput) {
                case "d": {
                    searchByDepartment(inventory, cart);
                }
                case "p": {
                    //searchByPrice(inventory, cart);
                }
                case "n": {
                    //searchByName(inventory, cart);
                }
                case "s": {
                    searchBySKU(inventory, cart);
                }
                case "e": {
                    break;
                }
            }
        }
    }
}
