package application;

import database.dao.StudentsDAO;
import database.dao.StudentsTractatesDAO;
import database.dao.TractatesDAO;
import io.PrintToScreen;
import io.UserInput;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
//    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueApp = true;
        while (continueApp) {
            printMenu();
            PrintToScreen.getChoice();
            int choice = UserInput.getUserChoice();
            try {
                switch (choice) {
                    case (1):
                        TractatesDAO.displayAllTracs();
                        break;
                    case (2):
                        displayOneTrac();
                        break;
                    case (3):
                        StudentsDAO.displayAllStudentNames();
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
                        continueApp = false;
                        break;
                    default:
                        PrintToScreen.invalidInput();
                        break;
                }
                if(continueApp) {
                    PrintToScreen.enterToContinue();
                    UserInput.getString();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static void recordLearnedAmud() throws SQLException {
        String stuPerName = getPersonalName();
        String stuFamName = getFamilyName();
        boolean studentFound = StudentsDAO.doesStudentExist(stuPerName, stuFamName);
        if (studentFound) {
            int stuId = StudentsDAO.getStudentId(stuPerName, stuFamName);
            PrintToScreen.getTracName();
            String trac = UserInput.getString();
            int tracId = TractatesDAO.getTractateId(trac);
            int page = getPage();
            boolean pageIsValid = TractatesDAO.isPageValid(tracId, page);
            if (pageIsValid) {
                boolean getDate = shouldGetDateFromUser();
                recordLearning(getDate, stuId, tracId, page);
            } else PrintToScreen.invalidInput();
        } else PrintToScreen.invalidInput();
    }

    private static boolean shouldGetDateFromUser() {
        PrintToScreen.shouldGetDate();
        PrintToScreen.yForYes();
        boolean getDate = UserInput.shouldGetDate();
        return getDate;
    }

    private static String getFamilyName() {
        PrintToScreen.getFamilyName();
        return UserInput.getString();
    }

    private static String getPersonalName() {
        PrintToScreen.getPersonalName();
        return UserInput.getString();
    }

    private static void recordLearning(boolean getDate, int stuId, int tracId, int page) throws SQLException {
        Date date = null;
        if (getDate) {
            while (date == null) {
                date = UserInput.getDate();

                if (date != null) StudentsTractatesDAO.enterNewRow(stuId, tracId, page, date);
                else if (date == null) {
                    PrintToScreen.dateInvalid();
                    PrintToScreen.tryAgain();
                }
            }
        } else {
            StudentsTractatesDAO.enterNewRow(stuId, tracId, page);
        }
    }

    private static int getPage() {
        PrintToScreen.getDaf();
        int daf = UserInput.getInt();
        PrintToScreen.getAmud();
        char amud = UserInput.getAmud();
        int page = dafToPage(daf, amud);
        return page;
    }

    private static int dafToPage(int daf, char amud) {
        // minimum daf in all tractates is 2, and 'n' has been chosen to denote an invalid amud
        if (daf > 1 && amud != 'n') {
            // formula to convert daf and amud into page number, with 2a denoting "1," 2b denoting "2", etc
            if (amud == 'a') return 2 * daf - 3;
            return 2 * daf - 2;
        }
        return -1;
    }

    private static void deleteStudentFromDB() throws SQLException {
        String studentPersonalName = getPersonalName();
        String studentFamilyName = getFamilyName();
        boolean studentFound = StudentsDAO.doesStudentExist(studentPersonalName, studentFamilyName);
        if (studentFound) {
            int stuId = StudentsDAO.getStudentId(studentPersonalName, studentFamilyName);
            StudentsDAO.deleteStudent(stuId);
        } else {
            PrintToScreen.studentNotFound();
        }
    }

    private static void editStudentName() throws SQLException {
        PrintToScreen.getOldStudentName();
        String oldStudentPersonalName = getPersonalName();
        String oldStudentFamilyName = getFamilyName();
        boolean studentFound = StudentsDAO.doesStudentExist(oldStudentPersonalName, oldStudentFamilyName);
        if (studentFound) {
            int stuId = StudentsDAO.getStudentId(oldStudentPersonalName, oldStudentFamilyName);
            PrintToScreen.getNewStudentName();
            String newStudentPersonalName = getPersonalName();
            String newStudentFamilyName = getFamilyName();
            StudentsDAO.changeStudentName(
                    stuId,
                    newStudentPersonalName,
                    newStudentFamilyName
            );
        } else {
            PrintToScreen.studentNotFound();
        }
    }

    private static void addNewStudentToDB() throws SQLException {
        PrintToScreen.getNewStudentName();
        String studentPersonalName = getPersonalName();
        String studentFamilyName = getFamilyName();
        StudentsDAO.addStudentToDB(studentPersonalName, studentFamilyName);
    }

    private static void addNewTracToDB() throws SQLException {
        PrintToScreen.getTracName();
        String tracName = UserInput.getString();
        boolean tracExists = TractatesDAO.doesTracExist(tracName);
        if (tracExists == false) {
            PrintToScreen.getTracPages();
            int tracPages = UserInput.getNumPages();
            if (tracPages > 0) TractatesDAO.addTracToDB(tracName, tracPages);
            else PrintToScreen.invalidNumPages();
        } else PrintToScreen.tracAlreadyExists();
    }

    private static void displayOneTrac() throws SQLException {
        PrintToScreen.getTracName();
        String tracName = UserInput.getString();
        boolean tracFound = TractatesDAO.doesTracExist(tracName);
        if (tracFound) TractatesDAO.displayOneTrac(tracName);
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
}