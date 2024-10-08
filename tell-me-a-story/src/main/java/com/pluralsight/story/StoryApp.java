package com.pluralsight.story;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryApp {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("./src/main/goldilocks.txt");

        Scanner fileScanner = new Scanner(fis);
        while(fileScanner.hasNextLine()){
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
    }
}
