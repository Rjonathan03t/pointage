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
    void createNewPerson() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary guardianSalary = new Salary(100000);
        Employee rakoto = new Employee("Rakoto",1,"2003-08-07","2024-05-05","2027-05-05",guardianSalary,false);
        Employee rabe = new Employee("rabe",2,"2002-08-07","2024-02-05","2027-02-05",guardianSalary,true);
        Guardian guardian = new Guardian("Guardian",rakoto);
        rakoto.setCategory(guardian);
        CalendarWork calendarWork = new CalendarWork(june,holiday,normalEmployeeWorkMonth);
        assertEquals(300,calendarWork.calculateHourOfWorkOfGuardian(rakoto));
        assertEquals(420,calendarWork.calculateHourOfWorkOfGuardian(rabe));
    }

}
