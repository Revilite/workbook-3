package com.pluralsight.onlinestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchProducts {
    private static Scanner scan = new Scanner(System.in);

    public static void addToCart(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        String isUserFinished = "n";
        do {
            ArrayList<Product> tempList = new ArrayList<>();
            System.out.println("Enter the name of the item you want to add");
            String productName = scan.nextLine();
            for (Product item : inventory.values()) {
                if (item.getProductName().equalsIgnoreCase(productName)) {
                    cart.put(item.getSku(), item);
                    tempList.add(item);
                }
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

    public static void searchByDepartment(HashMap<String, Product> inventory, HashMap<String, Product> cart, String searchBy) throws InterruptedException {
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
                System.out.println("We didn't find any " + searchBy + " with that name!");
            } else {
                //Add a number system to buy specific items
                addToCart(inventory, cart);
                return;
            }
        }
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
                    searchByDepartment(inventory, cart, "department");
                }
                break;
                case "p": {
                    searchByDepartment(inventory, cart, "price");
                }
                break;
                case "n": {
                    searchByDepartment(inventory, cart, "name");
                }
                break;
                case "s": {
                    searchByDepartment(inventory, cart, "SKU");
                }
                break;
                case "e": {
                    return;
                }
            }
        }
    }
}
