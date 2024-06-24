package org.example.model.employe;

import org.example.model.employe.category.Category;
import org.example.model.employe.salary.Salary;

public class Employee {
    private final String fullName;
    private final int serialNumber;
    private final String dateOfBirth;
    private final String hiringDate;
    private String endDateOfContract;
    private Salary salaryAmount;
    private Category category;

    public Employee(String fullName,
                    int serialNumber,
                    String dateOfBirth,
                    String hiringDate,
                    String endDateOfContract,
                    Salary salaryAmount,
                    Category category) {
        this.fullName = fullName;
        this.serialNumber = serialNumber;
        this.dateOfBirth = dateOfBirth;
        this.hiringDate = hiringDate;
        this.endDateOfContract = endDateOfContract;
        this.salaryAmount = salaryAmount;
        this.category = category;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public String getEndDateOfContract() {
        return endDateOfContract;
    }

    public Salary getSalaryAmount() {
        return salaryAmount;
    }

    public Category getCategory() {
        return category;
    }

}
