package org.example.model.employe.category;

import org.example.model.employe.NotImplemented;

public final class Driver extends Category {
    public Driver(String name, int normalWorkingHour, double salaryPerWeek, double compensation) {
        super(name, normalWorkingHour, salaryPerWeek,compensation);
    }

    @Override
    public String additionalHour(int hour) {
        throw new NotImplemented();
    }
}
