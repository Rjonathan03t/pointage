package org.example.model.employe.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarWork {
    private List<LocalDate> month = new ArrayList<>();
    private List<LocalDate> publicHoliday  = new ArrayList<>();

    public CalendarWork(List<LocalDate> month, List<LocalDate> publicHoliday) {
        this.month = month;
        publicHoliday.add(LocalDate.of(2024, 6, 17));
        publicHoliday.add(LocalDate.of(2024, 6, 25));
        publicHoliday.add(LocalDate.of(2024, 6, 26));
    }

    public void completMonthOfJune() {
        LocalDate beginningOfTheMonth = LocalDate.of(2024, 6, 1);
        LocalDate endOfTheMonth = beginningOfTheMonth.withDayOfMonth(beginningOfTheMonth.lengthOfMonth());
        for (LocalDate date = beginningOfTheMonth; !date.isAfter(endOfTheMonth); date = date.plusDays(1)) {
            month.add(date);
        }
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
