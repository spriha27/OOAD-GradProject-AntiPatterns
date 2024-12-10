package code.squarewheel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 1, 10);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between: " + daysBetween);
    }
}