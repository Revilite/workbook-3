package com.pluralsight.onlinestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class StoreFront {
    public static HashMap<String, Product> fillStore() throws IOException {
        //initializing
        BufferedReader buffRead;
        buffRead = new BufferedReader(new FileReader("./src/main/resources/DataFiles/products.csv"));
        HashMap<String, Product> inventory = new HashMap();

        //Skips heading line and adds items to array list
        String input = buffRead.readLine();
        while ((input = buffRead.readLine()) != null) {
            String[] value = input.split("[|]");
            Product item = new Product(value[0], value[1], Double.parseDouble(value[2]), value[3]);
            inventory.put(value[0], item);
        }

        return inventory;
    }

    public static void displayAllProducts(HashMap<String, Product> inventory, HashMap<String, Product> cart) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
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
            switch (productPageChoice) {
                case "s": {
                    //Searches item by SKU (not case-sensitive)
                    //TODO: Maybe add department searching
                    boolean invalidSKU = true;
                    String userSKU = "";
                    while (invalidSKU) {
                        System.out.println("What is the SKU of the item your looking for? (type \"x\" to exit)");
                        userSKU = scan.nextLine().toUpperCase();
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
                    }
                    //Gets user input if they want to save this item or not
                    System.out.println("Would you like to add this item to your cart? (Y/N)");
                    String addItemFromSearch = scan.nextLine().toLowerCase();

                    //Adds item and removes from inventory
                    if (addItemFromSearch.equals("y")) {
                        cart.put(userSKU, inventory.get(userSKU));
                        inventory.remove(userSKU);
                        System.out.println("Added Successfully!");
                        Thread.sleep(1000);
                    } else if (addItemFromSearch.equals("n")) {
                        break;
                    } else {
                        System.out.println("That isn't a choice");
                        Thread.sleep(1000);
                    }
                }
                case "c": {
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
                case "b": {
                    break;
                }
                default: {
                    System.out.println("That's not a good choice");
                    Thread.sleep(1000);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Product> inventory = new HashMap<>();
        HashMap<String, Product> cart = new HashMap<>();
        try {
            inventory = fillStore();
        } catch (IOException e) {
            System.out.println("Failed to fill store!");
        }
        System.out.println("""
                    Welcome to my online store!
                """);

        String userIsDone = "";
        while (!userIsDone.equals("e")) {
            System.out.println("""
                    Display All Products (P)
                    Display Your Cart    (C)
                    Exit Program         (E)
                    """);

            userIsDone = scan.nextLine().toLowerCase();
            switch (userIsDone) {
                case "p": {
                    try {
                        displayAllProducts(inventory, cart);
                    } catch (InterruptedException e) {
                        System.out.println("Cannot Display Products");
                    }
                }
            }
        }
    }


}

