package com.pluralsight.onlinestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class StoreFront {
    //Public variables = bad practice :(

    public static HashMap<String, Product> fillStore(HashMap<String, Product> inventory) throws IOException {
        //initializing
        BufferedReader buffRead;
        buffRead = new BufferedReader(new FileReader("./src/main/resources/DataFiles/products.csv"));
        //Skips heading line and adds items to array list
        String input = buffRead.readLine();
        while ((input = buffRead.readLine()) != null) {
            String[] value = input.split("[|]");
            Product item = new Product(value[0], value[1], Double.parseDouble(value[2]), value[3]);
            inventory.put(value[0], item);
        }
        return inventory;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Product> inventory = new HashMap<>();
        HashMap<String, Product> cart = new HashMap<>();

        Product item1 = new Product("dasd", "something", 10, "electronics");
        Product item2 = new Product("asfsagd", "nothing", 1123.12, "stores");
        Product item3 = new Product("sdfge", "everything", 123.23, "games");
        Product item4 = new Product("sdfasf", "Desktop PC Computer Intel Core I5", 112, "something else entirley");
        cart.put(item1.getSku(), item1);
        cart.put(item2.getSku(), item2);
        cart.put(item3.getSku(), item3);
        cart.put(item4.getSku(), item4);


        //Fills inventory with items
        try {
            fillStore(inventory);
        } catch (IOException e) {
            System.out.println("Failed to fill store!");
        }

        System.out.print("""
                
                
                  Welcome to my online store!
                
                """);

        String userIsDone = "";
        while (!userIsDone.equals("e")) {
            System.out.print("""
                    Display All Products (1)
                    Display Your Cart    (2)
                    Exit Program         (3)
                    """);
            userIsDone = scan.nextLine().toLowerCase();
            //Switch case did NOT work :(
            if (userIsDone.equals("1")) {
                try {
                    DisplayAllProducts.displayAllProducts(inventory, cart);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (userIsDone.equals("2")) {
                try {
                    DisplayCart.displayCart(inventory, cart);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (userIsDone.equals("3")) {
                return;
            } else {
                System.out.println("Please pick one of the options\n");
                Thread.sleep(1000);
            }
        }
    }
}


