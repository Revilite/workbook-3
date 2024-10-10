package com.pluralsight.formatdates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class FormatDates {

    public static String formatTime(String pattern, String timeZone){
        LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone));


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

        return fmt.format(now);
    }

    public static void main(String[] args) {

        //Get right now in UTC time zone
        System.out.println(formatTime("MM/dd/yyyy", "UTC"));
        System.out.println(formatTime("yyyy-MM-dd", "UTC"));
        System.out.println(formatTime("MMMM d, yyyy", "UTC"));
        System.out.println(formatTime("EEE, MMM d, yyyy  hh:mm", "UTC"));

        //Get right now in EST time zone
        System.out.println(formatTime("MM/dd/yyyy", "America/New_York"));
        System.out.println(formatTime("yyyy-MM-dd", "America/New_York"));
        System.out.println(formatTime("MMMM d, yyyy", "America/New_York"));
        System.out.println(formatTime("EEE, MMM d, yyyy hh:mm", "America/New_York"));

    }
}
