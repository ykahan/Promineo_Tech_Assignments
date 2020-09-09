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
}
