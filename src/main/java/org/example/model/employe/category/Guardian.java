package org.example.model.employe.category;

import org.example.model.employe.Employee;
import org.example.model.employe.NotImplemented;

public final class Guardian extends Category {
    public Guardian(String name,Employee employee){
        super(name, 110000, 0);
        this.normalWorkingHour = getNormalWorkingHour(employee);
    }
    @Override
    public String additionalHour(int heure) {
        throw new NotImplemented();
    }

    @Override
    public int getNormalWorkingHour(Employee employee) {
        int workHour = 0;
        if(employee.isWorkerLate()){
            workHour += 14;
        }else if(!employee.isWorkerLate()){
            workHour += 10;
        }
        return workHour;
    }
}
