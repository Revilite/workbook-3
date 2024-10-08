package com.pluralsight.story;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BedtimeStories {

    public static void printStory(String name) {
        try {
            FileInputStream fis = new FileInputStream("./DataFiles/" + name);
            Scanner scanFile = new Scanner(fis);
            while (scanFile.hasNextLine()) {
                System.out.println(scanFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Im sorry that name doesn't exist!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the name of a story: ");
        String story = scan.nextLine();
        printStory(story);
    }
}
