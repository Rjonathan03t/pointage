package org.example.model.employe.calendar;

import org.example.model.employe.Employee;
import org.example.model.employe.salary.Salary;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarWork {
    private List<LocalDate> month ;
    private List<LocalDate> normalEmployeeWorkMonth;
    private List<LocalDate> publicHoliday;
    private Employee employee;
    private List<LocalDate> week;

    public CalendarWork(List<LocalDate> month, List<LocalDate> publicHoliday,List<LocalDate>normalEmployeeWorkMonth) {
        this.month = month;
        this.normalEmployeeWorkMonth = normalEmployeeWorkMonth;
        this.publicHoliday = publicHoliday;
        this.week = new ArrayList<>();
    }

    public List<LocalDate> completMonthOfJune() {
        LocalDate beginningOfTheMonth = LocalDate.of(2024, 6, 1);
        LocalDate endOfTheMonth = beginningOfTheMonth.withDayOfMonth(beginningOfTheMonth.lengthOfMonth());
        for (LocalDate date = beginningOfTheMonth; !date.isAfter(endOfTheMonth); date = date.plusDays(1)) {
            if(!isWeekEnd(date)){
                normalEmployeeWorkMonth.add(date);
                month.add(date);
            }else if(isWeekEnd(date)){
                week.add(date);
                month.add(date);
            }
            if(isHoliday(date)){
                publicHoliday.add(date);
            }
        }
        return month;
    }

    public void showMonth(){
        completMonthOfJune();
        System.out.println("all month : "+ month);
        System.out.println("holiday in this month : "+ publicHoliday);
        System.out.println("week in this month : "+week);
    }

    public int calculateHourOfWorkOfGuardian(Employee employee){
        int totalHourMonth = 0;
        int normalWorkHourPerDay = employee.getCategory().getNormalWorkingHour(employee);
        completMonthOfJune();
        for(LocalDate date: month){
             totalHourMonth += normalWorkHourPerDay;
        }
        System.out.println("total of working hour : "+totalHourMonth+"h");
        return totalHourMonth;
    }

    public Double salaryAmount(Employee employee){
        int totalHour = calculateHourOfWorkOfGuardian(employee);
        Salary totalSalary = new Salary(employee.getSalaryAmount().getGrossSalary());
        double normalSalary = employee.getSalaryAmount().getGrossSalary();
        if(totalHour == 240 && !employee.isWorkerLate()){
            normalSalary = totalSalary.getGrossSalary();
        }else if (totalHour == 240 && employee.isWorkerLate()){
            normalSalary = normalSalary * 0.3;
        }
        System.out.println(normalSalary);
        return normalSalary;
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
            if (
                    date.equals(LocalDate.of(2024, 6, 17)) ||
                            date.equals(LocalDate.of(2024, 6, 25)) ||
                            date.equals(LocalDate.of(2024, 6, 26)
                            )) {
                return true;
            }
        return false;
    }
}
