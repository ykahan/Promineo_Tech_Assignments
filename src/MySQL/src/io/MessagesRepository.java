package io;

public class MessagesRepository {
    public static String goodbye() {
        return "Thank you for using this application.  Goodbye.";
    }

    public static String yForYes() {
        return "Type \"Y\" or \"Yes\" for yes, or anything else for no.";
    }

    public static String shouldGetDate() {
        return "Do you want to provide a date?";
    }

    public static String getFamilyName() {
        return "Family name:";
    }

    public static String getPersonalName() {
        return "Personal name:";
    }

    public static String tryAgain() {
        return "Please try again";
    }

    public static String dateInvalid() {
        return "The date entered was invalid";
    }

    public static String getYear() {
        return "Year as an integer:";
    }

    public static String getMonth() {
        return "Month as an integer:";
    }

    public static String getDay() {
        return "Day of the month as an integer:";
    }

    public static String displayStudent(int id, String name) {
        return "ID #" + id + ":\tName: " + name;
    }

    public static String tracNotFound() {
        return "That tractate was not found in the database.";
    }

    public static String tracAlreadyExists() {
        return "That tractate already exists in the database.";
    }

    public static String invalidNumPages() {
        return "Number of pages must be a positive integer.";
    }

    public static String getTracPages() {
        return "Enter number of pages";
    }

    public static String getTracName() {
        return "Enter tractate name, please.";
    }

    public static String displayTrac(String tracName, int numPages) {
        return "Tractate " + tracName + " has " + numPages + " pages";
    }

    public static String invalidInput() {
        return "Input invalid.";
    }

    public static String getChoice() {
        return "Please enter option number.";
    }

    public static String getDaf() {
        return "Daf:";
    }

    public static String getAmud() {
        return "Amud (A or B):";
    }

    public static String studentNotFound() {
        return "Student not found in database.";
    }

    public static String getOldStudentName() {
        return getStudentName("old");
    }

    public static String getNewStudentName() {
        return getStudentName("new");
    }

    private static String getStudentName(String descriptor){
        return "Please provide " + descriptor + " name of student.";
    }

    public static String getDateUnit(String type) {
        return "Provide " + type;
    }
}
