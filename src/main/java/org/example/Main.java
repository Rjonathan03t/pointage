package org.example;

import org.example.model.employe.Employee;
import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.category.Category;
import org.example.model.employe.category.Guardian;
import org.example.model.employe.salary.Salary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        Salary rakotoSalary = new Salary(3000);
        Employee rakoto = new Employee("Rakoto",1,"2003-08-07","2024-05-05","2027-05-05",rakotoSalary,false);
        Employee rabe = new Employee("Rabe",2,"2003-08-07","2024-05-05","2027-05-05",rakotoSalary,true);
        Guardian guardianRakoto = new Guardian("Guardian",rakoto);
        Guardian guardianRabe = new Guardian("Guardian",rabe);
        rakoto.setCategory(guardianRakoto);
        rabe.setCategory(guardianRabe);
        CalendarWork calendarWork = new CalendarWork(june,holiday,normalEmployeeWorkMonth);
        calendarWork.calculateHourOfWorkOfGuardian(rabe);
        /**calendarWork.showMonth();*/
        /**calendarWork.salaryAmount(rabe);*/
        }
    }

