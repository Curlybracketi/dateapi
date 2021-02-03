package com.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
/**
*
*@author Elvis Chinaka
*
 */
public class DateApi {

    public void calendarDate() {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.set(1994, 02, 14);
        System.out.println("calender date");
        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
    }

    public void compareDate() {
        LocalDate date1 = LocalDate.of(1994, 02, 14);
        LocalDate date2 = LocalDate.now();
        System.out.println("compare date");
        System.out.println(date1.isAfter(date2));
        System.out.println(date1.isBefore(date2));

    }

    public void compareTime() {
        LocalTime time1 = LocalTime.of(22, 32, 43);
        LocalTime time2 = LocalTime.now();
        System.out.println("compare time");
        System.out.println(time1.isAfter(time2));
        System.out.println(time2.isBefore(time2));
    }

    public void compareDateTIme() {
        LocalDateTime dateTime1 = LocalDateTime.of(1994, 02, 14, 4, 2);
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println("compare date and time");
        System.out.println(dateTime1.isAfter(dateTime2));
        System.out.println(dateTime1.isBefore(dateTime2));
    }

    public void measureTime() throws InterruptedException {
        long time = System.currentTimeMillis();
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - time);
    }

    public void periodBetweenDates() {
        Calendar dateOfBirth = Calendar.getInstance();
        Calendar actual = Calendar.getInstance();
        dateOfBirth.set(1994, 02, 14);
        actual.set(2021, 01, 19);

        int years = 0;
        while (dateOfBirth.before(actual)) ;
        dateOfBirth.add(Calendar.YEAR, 1);
        if (dateOfBirth.before(actual)) ;
        {
            years++;
        }
        System.out.println(years);
    }

    public void periodBetweenDate() {
        LocalDate dateOfBirth = LocalDate.of(1994, 02, 14);
        LocalDate actual = LocalDate.now();
        Period period = Period.between(dateOfBirth, actual);
        System.out.println(" have elapsed " + period.getYears() + " years " + period.getMonths()
                + " months and " + period.getDays() + "days since" + dateOfBirth + " until " + actual);
    }

    public void convert() throws ParseException {
        String date = "14/02/1994";
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date convertDate = formatter.parse(date);
        System.out.println(convertDate);
        Date actualDate = Calendar.getInstance().getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        String closeDate = formatter.format(actualDate);
        System.out.println(closeDate);
    }

    public void converts() {
        String date = "14/02/1994";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        System.out.println(formatter.format(localDate));

        formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        System.out.println(formatter.format(localDate));
    }

    public void readValuesLocalDate() {
        LocalDate date = LocalDate.of(2020, 3, 13);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        System.out.println(date + "\n" + year + "\n" + month + "\n" + day + "\n" + dayOfWeek + "\n" + len + "\n" + leap);
    }

    public void readValuesLocalTime() {
        LocalTime time = LocalTime.of(12, 3, 12);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(time + "\n" + hour + "\n" + minute + "\n" + second);
    }

    public void parseLocalDateLocalTime() {
        LocalDate date = LocalDate.parse("2020-3-13");
        LocalTime time = LocalTime.parse("12:3:13");
        System.out.println(date + "\n" + time);
    }

    public void parseLocalDateAndLocalTime() {
        LocalDate date = LocalDate.parse("2020-2-13");
        LocalTime time = LocalTime.parse("12:3:12");
        LocalDateTime dt1 = LocalDateTime.of(2020, Month.MARCH, 13, 12, 3, 13);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(12, 3, 13);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1 + "\n" + dt2 + "\n" + dt3 + "\n" + dt4 + "\n" + dt5);
    }

    public void extractLocalDateOrLocalDate() {
        LocalDateTime dt1 = LocalDateTime.of(2020, Month.MARCH, 13, 12, 3, 13);
        LocalDate date1 = dt1.toLocalDate();
        LocalDate time1 = dt1.toLocalDate();
        System.out.println(date1 + "\n" + time1);
    }

    public void instant() throws InterruptedException {
        /* this  overload version adjusts the nanosecond argument,
        ensuring that the stored nanosecond fraction is between 0 and 999,999,999.
         */
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(4, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println(instant1 + "\n" + instant2 + "\n" + instant3 + "\n" + instant4);
    }

    public void durationMethod() throws InterruptedException {
        Duration d1 = Duration.between(LocalTime.of(14, 32, 45),
                LocalTime.of(14, 35, 54));
        LocalDateTime dt1 = LocalDateTime.of(2021, Month.JANUARY, 30, 14, 32, 45);
        LocalDateTime dt2 = LocalDateTime.of(2021, Month.JANUARY, 30, 14, 32, 34);
        Duration d2 = Duration.between(dt1, dt2);
        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration d3 = Duration.between(instant1, instant2);
        System.out.println(d1.toSeconds() + "\n" + d2.toMinutes() + "\n" + d3.toSeconds());

        // creating Durations
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration fourMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(threeMinutes.toMinutes() + "\n" + fourMinutes.toMinutes());
    }

    public void periodMethod() {
        Period tenDays = Period.between(LocalDate.of(2021, 3, 30),
                LocalDate.of(2021, 3, 30));
        System.out.println(tenDays.getDays());

        // creating Periods
        Period nineDays = Period.ofDays(9);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(nineDays + "\n" + threeWeeks + "\n" + twoYearsSixMonthsOneDay);
    }

    public void manipulateDAtes() {
        LocalDate date1 = LocalDate.of(2021, 7, 30);
        LocalDate date2 = date1.withMonth(6);
        LocalDate date3 = date1.withYear(2021);
        LocalDate date4 = date1.withDayOfMonth(30);
        LocalDate date5 = date1.withDayOfYear(365);
        System.out.println(date1 + "\n" + date2 + "\n" + date3 + "\n" + date4 + "\n" + date5);
    }

    public void manipulateLocalDate() {
        LocalDate date1 = LocalDate.of(2021, 3, 30);
        LocalDate date2 = date1.plusWeeks(1);
        LocalDate date3 = date2.minusYears(6);
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
        System.out.println(date1 + "\n" + date2 + "\n" + date3 + "\n" + date4);
    }

    public static void main(String[] args) {
        DateApi dateApi = new DateApi();
        dateApi.manipulateLocalDate();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}