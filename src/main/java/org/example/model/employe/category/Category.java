package org.example.model.employe.category;

import org.example.model.employe.Employee;

public sealed abstract class Category permits
        Senior,
        Driver,
        Guardian,
        Normal {
    private final String name;
    public int normalWorkingHour;
    public double salaryPerWeek;
    private double compensation;

    public Category(String name, double salaryPerWeek, double compensation) {
        this.name = name;
        this.normalWorkingHour = 0;
        this.salaryPerWeek = salaryPerWeek;
        this.compensation = compensation;
    }

    public abstract String additionalHour(int hour);

    public String getName() {
        return name;
    }

    public int getNormalWorkingHour() {
        return normalWorkingHour;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public double getCompensation() {
        return compensation;
    }

    public abstract int getNormalWorkingHour(Employee employee);
}
