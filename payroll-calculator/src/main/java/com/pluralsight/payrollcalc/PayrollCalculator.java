package com.pluralsight.payrollcalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PayrollCalculator {
    public static void main(String[] args) throws IOException {
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
}
