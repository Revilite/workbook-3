package com.pluralsight.searchenginelogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class SearchEngineLogger {
    public static void timeStamp(String input) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/logs.txt"));

        buffWrite.write(input);
        //Always close scanners!
        buffWrite.close();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter fts = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        StringBuilder sb = new StringBuilder(fts.format(LocalDateTime.now())).append(" launch\n");

        boolean stillSeaching = true;
        while (stillSeaching) {
            System.out.println("Enter a search term (X to exit)");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("X")) {
                sb.append(fts.format(LocalDateTime.now())).append(" exit");
                stillSeaching = false;
            } else {
                sb.append(fts.format(LocalDateTime.now())).append(" search: " + input + "\n");
            }
        }
        try {
            timeStamp(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
