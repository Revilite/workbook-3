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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Product> inventory = new HashMap<>();
        HashMap<String, Product> cart = new HashMap<>();
        HashMap<String, Product>[] store = new HashMap[]{inventory, cart};

        try {
            store[0] = fillStore();
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
            //Switch case did NOT work :(
            if (userIsDone.equalsIgnoreCase("P")) {
                try {
                    store = DisplayAllProducts.displayAllProducts(store[0], store[1]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (userIsDone.equalsIgnoreCase("C")) {
                try{
                store = DisplayCart.displayCart(store[0], store[1]);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


