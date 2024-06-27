package org.example.model.employe.calendar;

import org.example.model.employe.Employee;
import org.example.model.employe.increasedTime.IncreasedHour;
import org.example.model.employe.salary.Salary;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarWork {
    private List<LocalDate> month;
    private List<LocalDate> normalEmployeeWorkMonth;
    private List<LocalDate> publicHoliday;
    private List<LocalDate> week;

    public CalendarWork(List<LocalDate> month, List<LocalDate> publicHoliday, List<LocalDate> normalEmployeeWorkMonth) {
        this.month = month;
        this.normalEmployeeWorkMonth = normalEmployeeWorkMonth;
        this.publicHoliday = publicHoliday;
        this.week = new ArrayList<>();
    }

    public List<LocalDate> completeMonth(LocalDate beginning, LocalDate end) {
        for (LocalDate date = beginning; !date.isAfter(end); date = date.plusDays(1)) {
            if (!isWeekEnd(date)) {
                normalEmployeeWorkMonth.add(date);
                month.add(date);
            } else if (isWeekEnd(date)) {
                week.add(date);
                month.add(date);
            }
            if (isHoliday(date)) {
                publicHoliday.add(date);
            }
        }
        return month;
    }

    public void showMonth(LocalDate beginning, LocalDate end) {
        completeMonth(beginning, end);
        System.out.println("all month : " + month);
        System.out.println("holiday in this month : " + publicHoliday);
        System.out.println("week in this month : " + week);
    }

    public int calculateHourOfWork(Employee employee, IncreasedHour increasedHour, LocalDate beginning, LocalDate end) {
        int totalHourMonth = 0;
        int normalWorkHourPerDay = employee.getCategory().getNormalWorkingHour(increasedHour);
        completeMonth(beginning, end);
        for (LocalDate date : month) {
            totalHourMonth += normalWorkHourPerDay;
        }
        System.out.println(totalHourMonth);
        return totalHourMonth;
    }

    public double guardianSalary(Employee employee, IncreasedHour increasedHour, Salary salary, LocalDate beginning, LocalDate end) {
        double bonus = employee.bonusSalary(increasedHour);
        double normalSalary = salary.getGrossSalary();
        double s = 0;
        double totalSalary = 0;
        double dailySalary = normalSalary / 7;
        double extraHourDay = 0;
        completeMonth(beginning, end);
        List<LocalDate> extraHours = new ArrayList<>();
        for (LocalDate date : month) {
            if(isHoliday(date)){
                extraHours.add(date);
            }else
            s += dailySalary;
        }
        for(LocalDate extraHour : extraHours){
            extraHourDay += (dailySalary * bonus);
        }
        if (bonus > 0) {
            totalSalary += extraHourDay + s;
            System.out.println(totalSalary);
            return totalSalary;
        } else
            System.out.println(totalSalary);
        return totalSalary;
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

    public boolean isHoliday(LocalDate date) {
        if (date.equals(LocalDate.of(2024, 6, 26))) {
            return true;
        }
        return false;
    }
}
