package org.example.model.employe.calendar;

import org.example.model.employe.Employee;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarWork {
    private List<LocalDate> month ;
    private List<LocalDate> normalEmployeeWorkMonth;
    private List<LocalDate> publicHoliday  = new ArrayList<>();
    private Employee employee;

    public CalendarWork(List<LocalDate> month, List<LocalDate> publicHoliday,List<LocalDate>normalEmployeeWorkMonth) {
        this.month = month;
        this.normalEmployeeWorkMonth = normalEmployeeWorkMonth;
        publicHoliday.add(LocalDate.of(2024, 6, 17));
        publicHoliday.add(LocalDate.of(2024, 6, 25));
        publicHoliday.add(LocalDate.of(2024, 6, 26));
    }

    public List<LocalDate> completMonthOfJune() {
        LocalDate beginningOfTheMonth = LocalDate.of(2024, 6, 1);
        LocalDate endOfTheMonth = beginningOfTheMonth.withDayOfMonth(beginningOfTheMonth.lengthOfMonth());
        for (LocalDate date = beginningOfTheMonth; !date.isAfter(endOfTheMonth); date = date.plusDays(1)) {
            if(!isWeekEnd(date)){
                normalEmployeeWorkMonth.add(date);
                month.add(date);
            }else
            month.add(date);
        }
        return month;
    }

    public int calculateHourOfWorkOfGuardian(Employee employee){
        int totalHourMonth = 0;
        int normalWorkHourPerDay = employee.getCategory().getNormalWorkingHour();
        completMonthOfJune();
        for(LocalDate date: month){
             totalHourMonth += normalWorkHourPerDay;
        }
        System.out.println(totalHourMonth);
        return totalHourMonth;
    }

    public boolean isWeekEnd(LocalDate day) {
        DayOfWeek dayOfWeek = day.getDayOfWeek();
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        DayOfWeek sunday = DayOfWeek.SUNDAY;
        if (dayOfWeek.equals(saturday) || dayOfWeek.equals(sunday)) {
            return true;
        }
        return false;
    }

    public boolean isHoliday(LocalDate day) {
        for (LocalDate holiday : publicHoliday) {
            if (
                    holiday.equals(LocalDate.of(2024, 6, 17)) ||
                            holiday.equals(LocalDate.of(2024, 6, 25)) ||
                            holiday.equals(LocalDate.of(2024, 6, 17)
                            )) {
                return true;
            }
        }
        return false;
    }
}
