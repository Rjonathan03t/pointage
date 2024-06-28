package org.example.model.employe.salary;

import org.example.model.employe.Employee;

public class Salary {
    private final double grossSalary;
    public Salary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }
}
