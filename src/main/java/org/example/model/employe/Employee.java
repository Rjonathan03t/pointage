package org.example.model.employe;

import org.example.model.employe.category.Category;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

public class Employee {
    private final String fullName;
    private final int serialNumber;
    private final String dateOfBirth;
    private final String hiringDate;
    private String endDateOfContract;
    private Salary salaryAmount;
    private Category category;
    private IncreasedHour increasedHour;


    public Employee(String fullName,
                    int serialNumber,
                    String dateOfBirth,
                    String hiringDate,
                    String endDateOfContract,
                    Salary salaryAmount,
                    IncreasedHour increasedHour) {
        this.fullName = fullName;
        this.serialNumber = serialNumber;
        this.dateOfBirth = dateOfBirth;
        this.hiringDate = hiringDate;
        this.endDateOfContract = endDateOfContract;
        this.salaryAmount = salaryAmount;
        this.category = null;
        this.increasedHour = increasedHour;
    }

    public double bonusSalary(IncreasedHour increasedHour){
        double bonus = 0;
        if(increasedHour.isNight() && !increasedHour.isSunday()  ){
             bonus += 1.3;
        }else if (increasedHour.isSunday() && !increasedHour.isNight() ){
            bonus += 1.4;
        }else if (increasedHour.isNight() && increasedHour.isSunday()){
            bonus += 2.7;
        }
        return bonus;
    }

    public Salary getSalaryAmount() {
        return salaryAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFullName() {
        return fullName;
    }
}
