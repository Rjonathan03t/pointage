package org.example;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RakotoTest {
    @Test
    void workingHourRakoto() {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        Salary rakotoSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(false, false, false);
        Employee rakoto = new Employee("Rakoto", 2, "2003-08-07", "2024-05-05", "2027-05-05", rakotoSalary, rabeincreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rakoto, rabeincreasedHour, rakotoSalary);
        rakoto.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(june, holiday, normalEmployeeWorkMonth);

        assertEquals(420, calendarWork.calculateHourOfWork(rakoto, rabeincreasedHour,beginning,end));
    }

    @Test
    void salaryOfRakotoWithSunday() {
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(100000);
        IncreasedHour rakotoIncreasedHour = new IncreasedHour(false, false, true );
        Employee rakoto = new Employee("Rakoto", 2, "2003-08-07", "2024-05-05", "2027-05-05", rakotoSalary, rakotoIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rakoto, rakotoIncreasedHour, rakotoSalary);
        rakoto.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(607142.8571428569, calendarWork.guardianSalary(rakoto, rakotoIncreasedHour, rakotoSalary,beginning,end), 0.01);
    }

    @Test
    void workingHourRabe() {
        List<LocalDate> sixWeek = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(true, false, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeincreasedHour);
        Guardian guardianRabe = new Guardian("Guardian", rabe, rabeincreasedHour, rabeSalary);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(sixWeek, holiday, normalEmployeeWorkMonth);

        assertEquals(588, calendarWork.calculateHourOfWork(rabe, rabeincreasedHour,beginning,end));
    }

    @Test
    void salaryOfrabeSixMonth() {
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, false, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(779999.9999999998, calendarWork.guardianSalary(rabe, rabeIncreasedHour, rabeSalary,beginning,end), 0.01);
    }
}
