package com.pluralsight.story;

public class Employee {
    private int employeeId;
    private String name;
    private float hoursWorked;
    private float payRate;

    public Employee(int employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public float getGrossPay() {
        return hoursWorked * payRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", payRate=" + payRate +
                "}\n";
    }
}
