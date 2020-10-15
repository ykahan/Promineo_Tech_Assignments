package database.dao;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentsDAOTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @org.junit.jupiter.api.Test
    void getStudentId() throws SQLException {
        int id = StudentsDAO.getStudentId("Yehoshua", "Kahan");

        assertEquals(1, id);
    }

    @org.junit.jupiter.api.Test
    void displayAllStudentNames() throws SQLException{
        StudentsDAO.displayAllStudentNames();
        String out = outContent.toString();
        String expected = "ID #2:\tName: Almoni, Ploni";

        boolean expectedFound = out.contains(expected);
        expected = "ID #1:\tName: Kahan, Yehoshua";
        if(expectedFound) expectedFound = out.contains(expected);

        assertTrue(expectedFound);
    }

    @org.junit.jupiter.api.Test
    void doesStudentExist() throws SQLException {
        boolean exists = StudentsDAO.doesStudentExist("Yehoshua", "Kahan");

        assertTrue(exists);
    }

    @org.junit.jupiter.api.Test
    void deleteStudent() throws SQLException {
        String first = "FirstName";
        String last = "LastName";
        StudentsDAO.addStudentToDB(first, last);
        int id = StudentsDAO.getStudentId(first,last);
        StudentsDAO.deleteStudent(id);

        boolean exists = StudentsDAO.doesStudentExist(first, last);
        boolean notExists = !exists;

        assertTrue(notExists);
    }

    @org.junit.jupiter.api.Test
    void changeStudentName() throws SQLException {
        String first = "FirstName";
        String last = "LastName";
        StudentsDAO.addStudentToDB(first, last);
        int id = StudentsDAO.getStudentId(first, last);
        String newFirst = "NewFirst";
        String newLast = "NewLast";
        StudentsDAO.changeStudentName(id, newFirst, newLast);

        int newId = StudentsDAO.getStudentId(newFirst, newLast);

        StudentsDAO.deleteStudent(newId);

        assertEquals(id, newId);
    }

    @org.junit.jupiter.api.Test
    void addStudentToDB() throws SQLException {
        StudentsDAO.addStudentToDB("FirstName", "LastName");

        boolean exists = StudentsDAO.doesStudentExist("FirstName", "LastName");

        int id = StudentsDAO.getStudentId("FirstName", "LastName");
        StudentsDAO.deleteStudent(id);

        assertTrue(exists);
    }
}