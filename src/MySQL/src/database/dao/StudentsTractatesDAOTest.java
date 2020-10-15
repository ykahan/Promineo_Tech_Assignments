package database.dao;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTractatesDAOTest {

    @Test
    void enterNewRowWithDate() throws SQLException {
        String date = 1997 + "-" + 11 + "-" + 14;
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        int id = StudentsTractatesDAO.enterNewRow(1, 1, 12, sqlDate);

        boolean exists = StudentsTractatesDAO.doesRowExist(id);

        StudentsTractatesDAO.deleteRow(id);

        assertTrue(exists);
    }

    @Test
    void enterNewRowWithoutDate() throws SQLException {
        int id = StudentsTractatesDAO.enterNewRow(1, 1, 12);

        boolean exists = StudentsTractatesDAO.doesRowExist(id);

        StudentsTractatesDAO.deleteRow(id);

        assertTrue(exists);
    }
}