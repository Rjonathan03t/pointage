package org.example.model.employe.category;

import org.example.model.employe.NotImplemented;

public final class Guardian extends Category {
    public Guardian(String name, int normalWorkingHour, double salaryPerWeek, double compensation) {
        super(name, normalWorkingHour, salaryPerWeek,compensation);
    }
    public Guardian(String name){
        this(name,8,110000,0);
    }
    @Override
    public String additionalHour(int heure) {
        throw new NotImplemented();
    }

}
