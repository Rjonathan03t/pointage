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
    private boolean workerLate;


    public Employee(String fullName,
                    int serialNumber,
                    String dateOfBirth,
                    String hiringDate,
                    String endDateOfContract,
                    Salary salaryAmount,
                    boolean workerLate) {
        this.fullName = fullName;
        this.serialNumber = serialNumber;
        this.dateOfBirth = dateOfBirth;
        this.hiringDate = hiringDate;
        this.endDateOfContract = endDateOfContract;
        this.salaryAmount = salaryAmount;
        this.category = null;
        this.workerLate = workerLate;
    }

    public Salary getSalaryAmount() {
        return salaryAmount;
    }

    public Category getCategory() {
        return category;
    }
    public boolean isWorkerLate(){
        return workerLate;
    }
    public void setCategory(Category category) {
        this.category = category;
    }


}
