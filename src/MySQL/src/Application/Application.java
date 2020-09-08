package Application;

import Database_Controls.students_dao;
import Database_Controls.students_tractates_dao;
import Database_Controls.tractates_dao;

import java.sql.Date;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueApp = true;
        while (continueApp) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case (1): // display all tractates
                    tractates_dao.displayAllTracs();
                    break;
                case (2):
                    String tracName = tractates_dao.getTracName();
                    boolean tracFound = tractates_dao.doesTracExist(tracName);
                    if(tracFound) tractates_dao.displayOneTrac(tracName);
                    else Messages.tracNotFound();
                    break;
                case (3): // display all student names
                    students_dao.displayAllStudentNames();
                    break;
                case (4): // add new tractate to db
                    tracName = tractates_dao.getTracName();
                    int tracPages = tractates_dao.getTracPages();
                    tractates_dao.addTracToDB(tracName, tracPages);
                    break;
                case (5): // add new student
                    String studentPersonalName = students_dao.getStudentPersonalName();
                    String studentFamilyName = students_dao.getStudentFamilyName();
                    students_dao.addStudentToDB(studentPersonalName, studentFamilyName);
                    break;
                case (6): // edit student name
                    String oldStudentPersonalName = students_dao.getStudentPersonalName();
                    String oldStudentFamilyName = students_dao.getStudentFamilyName();
                    boolean studentFound = students_dao.doesStudentExist(oldStudentPersonalName, oldStudentFamilyName);
                    if (studentFound) {
                        Messages.needNewStudentName();
                        String newStudentPersonalName = students_dao.getStudentPersonalName();
                        String newStudentFamilyName = students_dao.getStudentFamilyName();
                        students_dao.changeStudentName(
                                oldStudentPersonalName,
                                oldStudentFamilyName,
                                newStudentPersonalName,
                                newStudentFamilyName
                        );
                    } else {
                        Messages.studentNotFound();
                    }
                    break;
                case(7): // delete student from DB
                    studentPersonalName = getStudentPersonalName();

                    studentFamilyName = getStudentFamilyName();
                    studentFound = students_dao.doesStudentExist(studentPersonalName, studentFamilyName);
                    if(studentFound) students_dao.deleteStudent(studentPersonalName, studentFamilyName);
                    else {
                        Messages.studentNotFound();
                    }
                    break;
                case(8): // record student learned daf
                    studentPersonalName = students_dao.getStudentPersonalName();
                    studentFamilyName = students_dao.getStudentFamilyName();
                    studentFound = students_dao.doesStudentExist(studentPersonalName, studentFamilyName);
                    if(studentFound) {
                        tracName = tractates_dao.getTracName();
                        int daf = tractates_dao.getDaf();
                        char amud = tractates_dao.getAmud();
                        int page = tractates_dao.dafToPage(daf, amud);
                        boolean pageIsValid = tractates_dao.isPageValid(page);
                        if(pageIsValid) {
                            boolean userProvidedDate = students_tractates_dao.useUserProvidedDate();
                            if(userProvidedDate) {
                                Date date = students_tractates_dao.getDate();
                                students_tractates_dao.enterNewRow(
                                       studentPersonalName,
                                       studentFamilyName,
                                       page,
                                       date
                                );
                            } else {
                                students_tractates_dao.enterNewRow(
                                        studentPersonalName,
                                        studentFamilyName,
                                        page
                                );
                            }
                        }
                    }
                case(9): // break out of app
                    continueApp = false;
                    Messages.goodbye();
            }
        }
    }

}

    public static void printMenu() {

    }

    public int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
