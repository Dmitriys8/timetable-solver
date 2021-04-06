package ru.sber.edu.timetable.enums;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;

@AllArgsConstructor
public enum Days {

    MONDAY(1, "monday", DayOfWeek.MONDAY),
    TUESDAY(2, "tuesday", DayOfWeek.TUESDAY),
    WEDNESDAY(3, "wednesday", DayOfWeek.WEDNESDAY),
    THURSDAY(4, "thursday", DayOfWeek.THURSDAY),
    FRIDAY(5, "friday", DayOfWeek.FRIDAY),
    SUNDAY(6, "sunday", DayOfWeek.SATURDAY),
    SATURDAY(7, "saturday", DayOfWeek.SUNDAY);

    private long dayOfWeekNumber;
    private String name;
    private DayOfWeek dayOfWeek;

    public static DayOfWeek getByName(String dayName){
        switch (dayName){
            case "tuesday":
                return TUESDAY.dayOfWeek;
            case "wednesday":
                return WEDNESDAY.dayOfWeek;
            case "thursday":
                return THURSDAY.dayOfWeek;
            case "friday":
                return FRIDAY.dayOfWeek;
            case "sunday":
                return SUNDAY.dayOfWeek;
            case "saturday":
                return SATURDAY.dayOfWeek;
            default:
                return MONDAY.dayOfWeek;
        }
    }

    public static String getNameByDay(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case TUESDAY:
                return TUESDAY.name;
            case MONDAY:
                return WEDNESDAY.name;
            case THURSDAY:
                return THURSDAY.name;
            case FRIDAY:
                return FRIDAY.name;
            case SUNDAY:
                return SUNDAY.name;
            case SATURDAY:
                return SATURDAY.name;
            default:
                return MONDAY.name;
        }
    }
}
