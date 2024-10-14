package com.pluralsight.application;

import java.io.*;

public class AddDeposit {
    public static void deposit(String info)throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/transaction.csv"));
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/transaction.csv"));


    }

}
