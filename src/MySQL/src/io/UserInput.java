package io;

import java.sql.Date;
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
    }    public static Date getDate() {
        int year = getYear();
        int month = getMonth();
        int day = getDay();
        boolean dateIsValid = isDateValid(year, month, day);
        if(dateIsValid) return (Date) new GregorianCalendar(year, month - 1, day).getTime();
        else return null;
    }

    private static boolean isDateValid(int year, int month, int day) {
        return year != -1 && month != -1 && day != -1;
    }

    private static int getDay() {
        scanner.nextLine();
        PrintToScreen.getDay();
        return getInteger();
    }

    private static int getMonth() {
        scanner.nextLine();
        PrintToScreen.getMonth();
        return getInteger();
    }

    private static int getYear() {
        scanner.nextLine();
        PrintToScreen.getYear();
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
}
