package database.dao;

import database.DB_Connection;
import io.PrintToScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsDAO {
    private static final String DELETE_STUDENT =
            "DELETE FROM students WHERE id = ?";
    private static final String CHANGE_STUDENT_NAME =
            "UPDATE students SET personal_name = ?, family_name = ? WHERE id = ?";
    private static final String ADD_NEW_STUDENT =
            "INSERT INTO students(personal_name, family_name) VALUES(?, ?)";
    static Connection conn = DB_Connection.getConnection();
    private static final String DISPLAY_ALL_STUDENTS_QUERY =
            "SELECT id, CONCAT(family_name, ', ', personal_name) " +
                    "FROM students " +
                    "ORDER BY family_name";
    private static final String GET_STUDENT_ID_QUERY =
            "SELECT id FROM students WHERE personal_name = ? AND family_name = ?";
    private static final String DOES_STUDENT_EXIST_QUERY =
            "SELECT COUNT(*) FROM students WHERE personal_name = ? AND family_name = ?";


    public static int getStudentId(String perName, String famName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(GET_STUDENT_ID_QUERY);
        pstmt.setString(1, perName);
        pstmt.setString(2, famName);
        ResultSet rset = pstmt.executeQuery();
        while(rset.next()) return rset.getInt(1);
        
        return -1;
    }

    public static void displayAllStudentNames() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DISPLAY_ALL_STUDENTS_QUERY);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) PrintToScreen.displayStudent(
                rset.getInt(1), rset.getString(2)
        );
    }

    public static boolean doesStudentExist(String perName, String famName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DOES_STUDENT_EXIST_QUERY);
        pstmt.setString(1, perName);
        pstmt.setString(2, famName);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
            return rset.getInt(1) > 0;
        return false;
    }

    public static void deleteStudent(int stuId) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DELETE_STUDENT);
        pstmt.setInt(1, stuId);
        pstmt.execute();
    }

    public static void changeStudentName(int stuId, String personalName, String familyName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(CHANGE_STUDENT_NAME);
        pstmt.setString(1, personalName);
        pstmt.setString(2, familyName);
        pstmt.setInt(3, stuId);
        pstmt.execute();
    }

    public static void addStudentToDB(String personalName, String familyName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(ADD_NEW_STUDENT);
        pstmt.setString(1, personalName);
        pstmt.setString(2, familyName);
        pstmt.execute();
    }
}