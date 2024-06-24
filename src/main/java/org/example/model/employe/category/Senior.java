package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;

public final class Senior extends Category {
    public Senior(String name, double salaryPerWeek, double compensation) {
        super(name, salaryPerWeek,compensation);
        this.normalWorkingHour = getNormalWorkingHour();
    }
    @Override
    public String additionalHour(int heure) {
        throw new NotImplemented();
    }

    @Override
    public int getNormalWorkingHour(Employee employee) {
        throw new NotImplemented();
    }
}
