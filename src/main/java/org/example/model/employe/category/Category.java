package org.example.model.employe.category;

public sealed abstract class Category permits
        Senior,
        Driver,
        Guardian,
        Normal {
    private final String name;
    private int normalWorkingHour;
    public double salaryPerWeek;
    private double compensation;

    public Category(String name, int normalWorkingHour, double salaryPerWeek, double compensation) {
        this.name = name;
        this.normalWorkingHour = normalWorkingHour;
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
}
