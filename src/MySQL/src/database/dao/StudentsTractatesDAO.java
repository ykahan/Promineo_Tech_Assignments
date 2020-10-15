package database.dao;

import database.DB_Connection;

import java.sql.*;

public class StudentsTractatesDAO {
    private static final String CREATE_NEW_ROW_WITH_DATE =
            "INSERT INTO students_tractates(student_id, tractate_id, page, date_studied) " +
                    "VALUES(?, ?, ?, ?)";
    private static final String CREATE_NEW_ROW_WITHOUT_DATE =
            "INSERT INTO students_tractates(student_id, tractate_id, page) " +
                    "VALUES(?, ?, ?)";
    private static final String DELETE_ROW =
            "DELETE FROM students_tractates WHERE id = ?";
    private static final String GET_LAST_ID_QUERY =
            "SELECT id FROM students_tractates ORDER BY id DESC LIMIt 1";
    private static final String DOES_ROW_EXIST_QUERY =
            "SELECT COUNT(*) FROM students_tractates WHERE id = ?";
    private static Connection conn = DB_Connection.getConnection();

    public static int enterNewRow(int stuId, int tracId, int page, Date date) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(CREATE_NEW_ROW_WITH_DATE);
        setStuTracPage(stuId, tracId, page, pstmt);
        pstmt.setDate(4, date);
        pstmt.execute();

        return getLastID();
    }

    public static boolean doesRowExist(int id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DOES_ROW_EXIST_QUERY);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    private static int getLastID() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(GET_LAST_ID_QUERY);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public static int enterNewRow(int stuId, int tracId, int page) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(CREATE_NEW_ROW_WITHOUT_DATE);
        setStuTracPage(stuId, tracId, page, pstmt);
        pstmt.execute();

        return getLastID();
    }

    private static void setStuTracPage(int stuId, int tracId, int page, PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, stuId);
        pstmt.setInt(2, tracId);
        pstmt.setInt(3, page);
    }

    public static void deleteRow(int id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DELETE_ROW);
        pstmt.setInt(1, id);
        pstmt.execute();
    }
}
