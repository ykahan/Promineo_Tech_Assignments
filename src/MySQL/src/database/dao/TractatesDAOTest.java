package database.dao;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TractatesDAOTest {
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
    @Test
    void displayAllTracs() throws SQLException {
        TractatesDAO.displayAllTracs();
        String out = outContent.toString();
        String expected = "Tractate Brachos has 125 pages";

        boolean expectedFound = out.contains(expected);
        expected = "Tractate Shabbos has 314 pages";
        if(expectedFound) expectedFound = out.contains(expected);

        assertTrue(expectedFound);
    }

    @Test
    void displayOneTrac() throws SQLException {
        String tractate = "Shabbos";
        TractatesDAO.displayOneTrac(tractate);
        String out = outContent.toString();
        String expected = "Tractate Shabbos has 314 pages";
        boolean expectedFound = out.contains(expected);

        assertTrue(expectedFound);
    }

    @Test
    void doesTracExist() throws SQLException {
        boolean exists = TractatesDAO.doesTracExist("Shabbos");

        assertTrue(exists);
    }

    @Test
    void addTracToDB() throws SQLException {
        String name = "tractate";
        int pages = 23;
        TractatesDAO.addTracToDB(name, pages);
        boolean exists = TractatesDAO.doesTracExist(name);
        TractatesDAO.deleteTractate(name);

        assertTrue(exists);
    }

    @Test
    void deleteTractate() throws SQLException {
        String name = "tractate";
        int pages = 23;
        TractatesDAO.addTracToDB(name, pages);
        TractatesDAO.deleteTractate(name);

        boolean exists = TractatesDAO.doesTracExist(name);
        boolean notExists = !exists;

        assertTrue(notExists);
    }

    @Test
    void getTractateId() throws SQLException {
        int expectedId = 1;
        int foundId = TractatesDAO.getTractateId("Brachos");

        assertEquals(expectedId, foundId);
    }

    @Test
    void isPageValid() throws SQLException {
        int page = 100;
        boolean resultAsExpected = TractatesDAO.isPageValid(1, page);
        page = 400;
        if(resultAsExpected) resultAsExpected = !TractatesDAO.isPageValid(1, page);

        assertTrue(resultAsExpected);
    }
}