package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;

public final class Normal extends Category {
    public Normal(String name, double salaryPerWeek, double compensation) {
        super(name, salaryPerWeek,compensation);
        this.normalWorkingHour = getNormalWorkingHour();
    }
    public Normal(String nom) {
        this(nom, 100000, 0);
    }


    @Override
    public String additionalHour(int hour) {
        double compensationAdditionnalHour = getCompensation();
        double normalSalaryPerWeek = getSalaryPerWeek();
        if(hour<20){
              if(hour <= 8){
                  compensationAdditionnalHour = getSalaryPerWeek() * 0.3;
                  normalSalaryPerWeek += compensationAdditionnalHour;
                  return "additional hour = "+hour+", indemnite = "+ compensationAdditionnalHour+", salaire par semaine = "+normalSalaryPerWeek;
              }else if(hour >= 12){
                  compensationAdditionnalHour = getSalaryPerWeek() * 0.5;
                  normalSalaryPerWeek += compensationAdditionnalHour;
                  return "additional hour = "+hour+", indemnite = "+ compensationAdditionnalHour+", salaire par semaine = "+normalSalaryPerWeek;
              }
        }
        return ("vous avez fait plus de 20h par semaine , -> 0 indemnite");
    }

    @Override
    public int getNormalWorkingHour(Employee employee) {
        throw new NotImplemented();
    }
}
