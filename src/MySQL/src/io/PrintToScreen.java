package io;

public class PrintToScreen {
    public static void getChoice() {
        System.out.println("Please enter option number.");
    }

    public static void invalidInput() {
        System.out.println("Input invalid.");
    }

    public static void displayTrac(String tracName, int numPages) {
        System.out.println(
                "Tractate " + tracName + " has " + numPages + " pages"
        );
    }

    public static void getTracName() {
        System.out.println("Enter tractate name.");
    }

    public static void getTracPages() {
        System.out.println("Enter number of pages");
    }

    public static void invalidNumPages() {
        System.out.println("Number of pages must be a positive integer.");
    }

    public static void tracAlreadyExists() {
        System.out.println("That tractate already exists in the database.");
    }

    public static void tracNotFound() {
        System.out.println("That tractate was not found in the database.");
    }

    public static void displayStudents(int id, String name) {
        System.out.println("\nID #" + id + ":\tName: " + name);
    }

    public static void getDay() {
        System.out.println("Day of the month as an integer:");
    }

    public static void getMonth() {
        System.out.println("Month as an integer:");
    }

    public static void getYear() {
        System.out.println("Year as an integer");
    }

    public static void dateInvalid() {
        System.out.println("The date entered was invalid");
    }

    public static void tryAgain() {
        System.out.println("Please try again");
    }

    public static void getPersonalName() {
        System.out.println("Personal name:");
    }

    public static void getFamilyName() {
        System.out.println("Family name:");
    }

    public static void shouldGetDate() {
        System.out.println("Do you want to provide a date?");
    }

    public static void yForYes(){
        System.out.println("Type \"Y\" or \"Yes\" for yes, or anything else for no.");
    }
}
