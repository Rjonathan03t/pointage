package org.example;

import org.example.model.employe.calendar.CalendarWork;
import org.example.model.employe.salary.Salary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> june = new ArrayList<>();
        List<LocalDate> holiday = new ArrayList<>();
        List<LocalDate> normalEmployeeWorkMonth = new ArrayList<>();
        CalendarWork calendarWork = new CalendarWork(june,holiday,normalEmployeeWorkMonth);
        calendarWork.completMonthOfJune();
        }
    }
