package io;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.nextLine();
    }

    public static int getNumPages() {
        int pages = -1;
        if(scanner.hasNextInt()) {
            pages = scanner.nextInt();
            if(pages <= 0) pages = -1;
        }
        return pages;
    }

    public static Date getDate() {
        int year = getDateUnit("year");
        int month = getDateUnit("month");
        int day = getDateUnit("day");
        boolean dateIsValid = isDateValid(year, month, day);
        if(dateIsValid) {
            String date = year + "-" + month + "-" + day;
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            return sqlDate;
        }
        else return null;
    }

    private static int getDateUnit(String type){
        PrintToScreen.getDateUnit(type);
        int unit = scanner.nextInt();
        scanner.nextLine();
        return unit;
    }

    private static boolean isDateValid(int year, int month, int day) {
        boolean dateIsValid = true;
        dateIsValid = yearIsValid(year);
        if(dateIsValid) dateIsValid = monthIsValid(month);
        if (dateIsValid) dateIsValid = dayIsValid(year, month, day);
        return dateIsValid;
    }

    private static boolean dayIsValid(int year, int month, int day) {
        if(day < 1) return false;
        if(month < 1) return false;
        if(month > 12) return false;
        if(year < 1000) return false;
        if(year > 9999) return false;
        switch(month){
            case(1):
            case(3):
            case(5):
            case(7):
            case(8):
            case(10):
            case(12):
                return day <= 31;
            case(4):
            case(6):
            case(9):
            case(11):
                return day <= 30;
            case(2):
                if(year % 400 == 0) return day <= 29;
                else if(year % 100 == 0) return day <= 28;
                else if(year % 4 == 0) return day <= 29;
                else return day <= 28;
        }
        return false;
    }

    private static boolean monthIsValid(int month) {
        return month >= 1 && month <= 12;
    }

    private static boolean yearIsValid(int year) {
        return year >= 1000 && year <= 9999;
    }

    private static int getDay() {
        PrintToScreen.getDay();
        scanner.nextLine();
        return getInteger();
    }

    private static int getMonth() {
        PrintToScreen.getMonth();
        scanner.nextLine();
        return getInteger();
    }

    private static int getYear() {
        PrintToScreen.getYear();
        scanner.nextLine();
        return getInteger();
    }

    private static int getInteger() {
        boolean isInt = scanner.hasNextInt();
        if (isInt) return scanner.nextInt();
        else return -1;
    }

    public static boolean shouldGetDate() {
        String response = scanner.nextLine();
        response = response.toLowerCase();
        if(response.equals("y")) return true;
        if(response.equals("yes")) return true;
        return false;
    }

    public static int getInt() {
        int num = -1;
        if(scanner.hasNext()) {
            num = scanner.nextInt();
            scanner.nextLine();
        }
        return num;
    }

    public static char getAmud() {
        char amud = 'n';
        String response = scanner.nextLine();
        response = response.toLowerCase();
        if(response.equals("a") || response.equals("b")){
            amud = response.charAt(0);
        }
        return amud;
    }

    public static int getUserChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        return choice;
    }
}
