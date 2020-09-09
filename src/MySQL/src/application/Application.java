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

    private static void recordLearnedAmud() throws SQLException {
        String stuPerName = getPersonalName();
        String stuFamName = getFamilyName();
        boolean studentFound = StudentsDAO.doesStudentExist(stuPerName, stuFamName);
        if (studentFound) {
            int stuId = StudentsDAO.getStudentId(stuPerName,  stuFamName);
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
        String stuFamName = UserInput.getString();
        return stuFamName;
    }

    private static String getPersonalName() {
        PrintToScreen.getPersonalName();
        String stuPerName = UserInput.getString();
        return stuPerName;
    }

    private static void recordLearning(boolean getDate, int stuId, int tracId, int page) throws SQLException {
        Date date = null;
        if (getDate) {
            while(date == null)
            date = UserInput.getDate();
            if(date != null) StudentsTractatesDAO.enterNewRow(stuId, tracId, page, date);
            else {
                PrintToScreen.dateInvalid();
                PrintToScreen.tryAgain();
            }
        } else {
            StudentsTractatesDAO.enterNewRow(stuId, tracId, page);
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
        boolean studentFound = StudentsDAO.doesStudentExist(studentPersonalName, studentFamilyName);
        if (studentFound) StudentsDAO.deleteStudent(studentPersonalName, studentFamilyName);
        else {
            PrintToScreen.studentNotFound();
        }
        return;
    }

    private static void editStudentName() {
        String oldStudentPersonalName = StudentsDAO.getStudentPersonalName();
        String oldStudentFamilyName = StudentsDAO.getStudentFamilyName();
        boolean studentFound = StudentsDAO.doesStudentExist(oldStudentPersonalName, oldStudentFamilyName);
        if (studentFound) {
            PrintToScreen.needNewStudentName();
            String newStudentPersonalName = StudentsDAO.getStudentPersonalName();
            String newStudentFamilyName = StudentsDAO.getStudentFamilyName();
            StudentsDAO.changeStudentName(
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
        String studentPersonalName = StudentsDAO.getStudentPersonalName();
        String studentFamilyName = StudentsDAO.getStudentFamilyName();
        StudentsDAO.addStudentToDB(studentPersonalName, studentFamilyName);
    }

    private static void addNewTracToDB() throws SQLException {
        PrintToScreen.getTracName();
        String tracName = UserInput.getString();
        boolean tracExists = TractatesDAO.doesTracExist(tracName);
        if(tracExists == false) {
            PrintToScreen.getTracPages();
            int tracPages = UserInput.getNumPages();
            if(tracPages > 0) TractatesDAO.addTracToDB(tracName, tracPages);
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

    public static int getUserChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }
        return choice;
    }
}