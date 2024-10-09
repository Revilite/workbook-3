package com.pluralsight.payrollcalc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollCalculator {

    public static void readEmployees() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("./src/main/resources/DataFiles/employees.csv"));
        ArrayList<Employee> employees = new ArrayList<>();


        String input = bufReader.readLine();

        while ((input = bufReader.readLine()) != null) {
            String[] values = input.split("[|]");
            Employee employee = new Employee(Integer.parseInt(values[0]), values[1], Float.parseFloat(values[2]), Float.parseFloat(values[3]));
            employees.add(employee);
            System.out.printf("""
                    Employee Name: %s    ID:%s      Gross Pay: %s  
                    """, employee.getName(), employee.getEmployeeId(), employee.getGrossPay());
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the file employee file to process: ");
        String employeeFile = scan.nextLine();
        System.out.println("Enter the name of the payroll file to create: ");
        String payrollFile = scan.nextLine();

        BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/DataFiles/" + employeeFile));
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/DataFiles/" + payrollFile));


        String input = buffRead.readLine();
        String[] parts = input.split("[|]");
        buffWrite.write(String.format("%s|%s|Gross-Payment \n", parts[0], parts[1], parts[2]));
        while((input = buffRead.readLine()) != null){
            parts = input.split("[|]");
            String writer = String.format("%s|%s|%.2f\n", parts[0], parts[1], (Double.parseDouble(parts[2]) * Double.parseDouble(parts[3])));
            buffWrite.write(writer);
        }
        //Always close scanners !
        buffWrite.close();
        buffRead.close();

    }
}
