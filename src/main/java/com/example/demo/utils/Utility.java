package com.example.demo.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Utility {
    public static boolean isBFCM() {

        LocalDate d = LocalDate.now();
        if(d.getMonthValue() == 11) {
            LocalDate d2 = d.with(
                    TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
            var d3=  d2.plusDays(1);
            return d.isAfter(d3) && d.isBefore(d3.plusDays(5));
        }
        return false;
    }
}
