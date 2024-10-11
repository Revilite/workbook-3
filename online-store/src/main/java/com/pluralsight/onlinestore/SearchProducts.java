package com.pluralsight.onlinestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchProducts {


    public static void addToCart(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String isUserFinished = "n";
        do {
            ArrayList<Product> tempList = new ArrayList<>();
            System.out.println("Enter the name of the item you want to add (enter \"x\" to exit)");
            String productName = scan.nextLine();
            for (Product item : inventory.values()) {
                if (item.getProductName().equalsIgnoreCase(productName)) {
                    cart.put(item.getSku(), item);
                    tempList.add(item);
                }
            }
            if (productName.equals("x")) {
                return;
            }
            if (tempList.isEmpty()) {
                System.out.println("We don't have that item!");
            } else {
                inventory.remove(tempList.get(0).getSku());
                System.out.println("Are you done adding items? (y/n)");
                isUserFinished = scan.nextLine();
                if (!isUserFinished.equalsIgnoreCase("y") && !isUserFinished.equalsIgnoreCase("n")) {
                    System.out.println("That is not y or n, returning to items");
                    Thread.sleep(1000);
                }
            }
        } while (isUserFinished.equalsIgnoreCase("n"));
    }

    public static void searchByValue(HashMap<String, Product> inventory, HashMap<String, Product> cart, String searchBy) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Product> tempList = new ArrayList();
        while (tempList.isEmpty()) {
            System.out.println("What " + searchBy + " are you looking for? (enter \"x\" to exit search)");
            String value = scan.nextLine();
            for (Product item : inventory.values()) {
                //Boolean variable ignores if statement????
                switch (searchBy) {
                    case "department": {
                        if (item.getDepartment().equalsIgnoreCase(value)) {
                            System.out.println(item);
                            tempList.add(item);
                        }
                    }
                    break;
                    case "name": {
                        if (item.getProductName().equalsIgnoreCase(value)) {
                            System.out.println(item);
                            tempList.add(item);
                        }
                    }
                    break;
                    case "price": {
                        if (item.getPrice() <= Double.parseDouble(value)) {
                            System.out.println(item);
                            tempList.add(item);
                        }
                    }
                    break;
                    case "SKU": {
                        if (item.getSku().equalsIgnoreCase(value)) {
                            System.out.println(item);
                            tempList.add(item);
                        }
                    }
                    break;
                }
            }
            if (value.equalsIgnoreCase("x")) {
                return;
            } else if (tempList.isEmpty()) {
                if (searchBy.equals("price")) {
                    System.out.println("\033[1;31mThere is no price under that amount!\033[1;0m");
                } else {
                    System.out.println("\033[1;31mWe didn't find any " + searchBy + "s with that name!\033[1;0m");
                }
                return;
            } else {
                //Add a number system to buy specific items
                addToCart(inventory, cart);
                return;
            }
        }
    }


    public static void searchItem(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String searchInput = "";
        while (!searchInput.equalsIgnoreCase("e")) {
            System.out.println("""
                    What would you like to search by?
                    Department   (1)
                    Price        (2)
                    Name         (3)
                    SKU          (4)
                    Exit         (5)
                    """);
            searchInput = scan.nextLine().toLowerCase();

            switch (searchInput) {
                case "1": {
                    searchByValue(inventory, cart, "department");
                }
                break;
                case "2": {
                    searchByValue(inventory, cart, "price");
                }
                break;
                case "3": {
                    searchByValue(inventory, cart, "name");
                }
                break;
                case "4": {
                    searchByValue(inventory, cart, "SKU");
                }
                break;
                case "5": {
                    return;
                }
            }
        }
    }
}
