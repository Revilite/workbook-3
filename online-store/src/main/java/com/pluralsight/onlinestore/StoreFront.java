package com.pluralsight.onlinestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreFront {
    public static ArrayList fillStore() throws IOException {
        BufferedReader buffRead;
        buffRead = new BufferedReader(new FileReader("./src/main/resources/DataFiles/products.csv"));
        ArrayList<Product> inventory = new ArrayList<>();

        String input = buffRead.readLine();
        while ((input = buffRead.readLine()) != null){
            String[] value = input.split("[|]");
            Product item = new Product(value[0], value[1], Double.parseDouble(value[2]), value[3]);
            inventory.add(item);
        }
        return inventory;
    }

    public static void main(String[] args) {
        try {
            System.out.println(fillStore());
        } catch (IOException e) {
            System.out.println("Failed to fill store");
        }



    }
}
