package application;

import database.dao.students_dao;
import database.dao.students_tractates_dao;
import database.dao.tractates_dao;
import io.PrintToScreen;
import io.UserInput;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueApp = true;
        while (continueApp) {
            printMenu();
            PrintToScreen.getChoice();
            int choice = getUserChoice();
            try {
                switch (choice) {
                    case (1):
                        tractates_dao.displayAllTracs();
                        break;
                    case (2):
                        displayOneTrac();
                        break;
                    case (3):
                        students_dao.displayAllStudentNames();
                        break;
                    case (4):
                        addNewTracToDB();
                        break;
                    case (5):
                        addNewStudentToDB();
                        break;
                    case (6):
                        editStudentName();
                        break;
                    case (7): // delete student from DB
                        deleteStudentFromDB();
                        break;
                    case (8): // record student learned daf
                        recordLearnedAmud();
                        break;
                    case (9): // break out of app
                        continueApp = false;
                        PrintToScreen.goodbye();
                        break;
                    default:
                        PrintToScreen.invalidInput();
                        break;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static void recordLearnedAmud() {
        String stuPerName = UserInput.getStudentPersonalName();
        String stuFamName = UserInput.getStudentFamilyName();
        boolean studentFound = students_dao.doesStudentExist(stuPerName, stuFamName);
        if (studentFound) {
            String trac = UserInput.getTracName();
            int page = getPage();
            boolean pageIsValid = tractates_dao.isPageValid(page);
            if (pageIsValid) {
                boolean getDate = UserInput.shouldGetDate();
                recordLearning(getDate, stuPerName, stuFamName, trac, page);
            }
        }
    }

    private static void recordLearning(boolean getDate, String stuPerName, String stuFamName, String trac, int page) {
        Date date = null;
        if (getDate) {
            while(date == null)
            date = UserInput.getDate();
            if(date != null) student_tractates_dao.enterNewRow(stuPerName, stuFamName, trac, page, date);
            else {
                PrintToScreen.dateInvalid();
                PrintToScreen.tryAgain();
            }
        } else {
            student_tractates_dao.enterNewRow(stuPerName, stuFamName, trac, page);
        }
    }

    private static int getPage() {
        int daf = UserInput.getDaf();
        char amud = UserInput.getAmud();
        int page = dafToPage(daf, amud);
        return page;
    }

    private static void deleteStudentFromDB() {
        String studentPersonalName = getStudentPersonalName();
        String studentFamilyName = getStudentFamilyName();
        boolean studentFound = students_dao.doesStudentExist(studentPersonalName, studentFamilyName);
        if (studentFound) students_dao.deleteStudent(studentPersonalName, studentFamilyName);
        else {
            PrintToScreen.studentNotFound();
        }
        return;
    }

    private static void editStudentName() {
        String oldStudentPersonalName = students_dao.getStudentPersonalName();
        String oldStudentFamilyName = students_dao.getStudentFamilyName();
        boolean studentFound = students_dao.doesStudentExist(oldStudentPersonalName, oldStudentFamilyName);
        if (studentFound) {
            PrintToScreen.needNewStudentName();
            String newStudentPersonalName = students_dao.getStudentPersonalName();
            String newStudentFamilyName = students_dao.getStudentFamilyName();
            students_dao.changeStudentName(
                    oldStudentPersonalName,
                    oldStudentFamilyName,
                    newStudentPersonalName,
                    newStudentFamilyName
            );
        } else {
            PrintToScreen.studentNotFound();
        }
    }

    private static void addNewStudentToDB() {
        String studentPersonalName = students_dao.getStudentPersonalName();
        String studentFamilyName = students_dao.getStudentFamilyName();
        students_dao.addStudentToDB(studentPersonalName, studentFamilyName);
    }

    private static void addNewTracToDB() throws SQLException {
        PrintToScreen.getTracName();
        String tracName = UserInput.getString();
        boolean tracExists = tractates_dao.doesTracExist(tracName);
        if(tracExists == false) {
            PrintToScreen.getTracPages();
            int tracPages = UserInput.getNumPages();
            if(tracPages > 0) tractates_dao.addTracToDB(tracName, tracPages);
            else PrintToScreen.invalidNumPages();
        } else PrintToScreen.tracAlreadyExists();
    }

    private static void displayOneTrac() throws SQLException {
        PrintToScreen.getTracName();
        String tracName = UserInput.getString();
        boolean tracFound = tractates_dao.doesTracExist(tracName);
        if (tracFound) tractates_dao.displayOneTrac(tracName);
        else PrintToScreen.tracNotFound();
    }

    public static void printMenu() {
        List<String> choices = Arrays.asList(
                "Display All Tractates",
                "Display One Tractate",
                "Display All Students",
                "Add a new tractate to the database",
                "Add a new student to the database",
                "Edit a student name",
                "Delete a student from the database",
                "Record a student learning an amud",
                "Quit the app"
        );

        for (int i = 0; i < choices.size(); i++) {
            System.out.println("Option #" + (i + 1) + ": " + choices.get(i));
        }
    }

    public static int getUserChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }
        return choice;
    }
}