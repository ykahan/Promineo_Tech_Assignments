package database.dao;

import database.DB_Connection;
import io.PrintToScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class students_dao {
    static Connection conn;
    private static final String DISPLAY_ALL_STUDENTS_QUERY =
            "SELECT id, CONCAT(family_name, ', ', personal_name) AS 'Students' " +
                    "FROM students " +
                    "ORDER BY family_name";
    public students_dao() throws SQLException {
        conn = DB_Connection.getConnection();

    }

    public static void displayAllStudentNames() throws SQLException {
        ResultSet rset = conn.prepareStatement(DISPLAY_ALL_STUDENTS_QUERY).executeQuery();
        while(rset.next()) PrintToScreen.displayStudents(
                rset.getInt(1), rset.getString(2)
        );
    }
}
