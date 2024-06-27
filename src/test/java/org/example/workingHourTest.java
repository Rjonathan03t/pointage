package org.example;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.salary.Salary;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class workingHourTest {
    @Test
    void workingHourRakoto() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(3000);
        Employee rakoto = new Employee("Rakoto",1,"2003-08-07","2024-05-05","2027-05-05",rakotoSalary,false);
        Guardian guardianRakoto = new Guardian("Guardian",rakoto);
        rakoto.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(june,holiday,normalEmployeeWorkMonth);

        assertEquals(300,calendarWork.calculateHourOfWorkOfGuardian(rakoto));
    }

    @Test
    void workingHourRabe(){
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(3000);
        Employee rabe = new Employee("Rabe",2,"2003-08-07","2024-05-05","2027-05-05",rabeSalary,true);
        Guardian guardianRabe = new Guardian("Guardian",rabe);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(june,holiday,normalEmployeeWorkMonth);

        assertEquals(420,calendarWork.calculateHourOfWorkOfGuardian(rabe));
    }

}
