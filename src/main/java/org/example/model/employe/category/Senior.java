package org.example.model.employe.category;

import org.example.model.employe.NotImplemented;

public final class Senior extends Category {
    public Senior(String name, int normalWorkingHour, double salaryPerWeek, double compensation) {
        super(name, normalWorkingHour, salaryPerWeek,compensation);
    }

    @Override
    public String additionalHour(int heure) {
        throw new NotImplemented();
    }
}
