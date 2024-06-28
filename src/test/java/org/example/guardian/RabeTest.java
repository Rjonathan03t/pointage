package org.example.guardian;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RabeTest {
    @Test
    void workingHourRabe() {
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        List<LocalDate> sixWeek = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeincreasedHour = new IncreasedHour(true, true);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeincreasedHour);
        Guardian guardianRabe = new Guardian("Guardian", rabe, rabeincreasedHour, rabeSalary);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(sixWeek, holiday, normalEmployeeWorkMonth);

        assertEquals(588, calendarWork.calculateHourOfWork(rabe, rabeincreasedHour,beginning,end,holidays));
    }

    @Test
    void grossSalaryOfRabeWithoutSunday() {
        double bonusRate = 1.5;
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 27);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(770714.2857142853, calendarWork.guardianSalary(rabe, rabeIncreasedHour, rabeSalary,beginning,end,holidays,bonusRate), 0.01);
    }

    @Test
    void netSalaryOfRabeWithoutSunday() {
        double bonusRate = 1.5;
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 27);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(616571.4285714283, calendarWork.netSalaryCalculation(rabe, rabeIncreasedHour, rabeSalary,beginning,end,holidays,bonusRate), 0.01);
    }

    @Test
    void grossSalaryOfRabeWithSunday() {
        double bonusRate = 1.5;
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 27);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, true);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(1600714.285714286, calendarWork.guardianSalary(rabe, rabeIncreasedHour, rabeSalary,beginning,end,holidays,bonusRate), 0.01);
    }

    @Test
    void grossSalaryOfRabeWithAllHoliday() {
        double bonusRate = 1.3;
        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(2024, 6, 17),
                LocalDate.of(2024,6,25),
                LocalDate.of(2024,6,26)
        );
        List<LocalDate> sixMonths = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        LocalDate beginning = LocalDate.of(2024, 5, 26);
        LocalDate end = LocalDate.of(2024, 7, 6);
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rabeSalary = new Salary(100000);
        IncreasedHour rabeIncreasedHour = new IncreasedHour(true, false);
        Employee rabe = new Employee("Rabe", 2, "2003-08-07", "2024-05-05", "2027-05-05", rabeSalary, rabeIncreasedHour);
        Guardian guardianRakoto = new Guardian("Guardian", rabe, rabeIncreasedHour, rabeSalary);
        rabe.setCategory(guardianRakoto);
        CalendarWork calendarWork = new CalendarWork(sixMonths, holiday, normalEmployeeWorkMonth);

        assertEquals(796714.2857142854, calendarWork.guardianSalary(rabe, rabeIncreasedHour, rabeSalary,beginning,end,holidays,bonusRate), 0.01);
    }

}
