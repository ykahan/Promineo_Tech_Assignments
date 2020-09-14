package database.dao;

import database.DB_Connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentsTractatesDAO {
    private static final String CREATE_NEW_ROW_WITH_DATE =
            "INSERT INTO students_tractates(student_id, tractate_id, page, date_studied) " +
                    "VALUES(?, ?, ?, ?)";
    private static final String CREATE_NEW_ROW_WITHOUT_DATE =
            "INSERT INTO students_tractates(student_id, tractate_id, page) " +
                    "VALUES(?, ?, ?)";
    private static Connection conn = DB_Connection.getConnection();

    private static final String CREATE_NEW_ROW =
            "";
    
    public static void enterNewRow(int stuId, int tracId, int page, Date date) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(CREATE_NEW_ROW_WITH_DATE);
        setStuTracPage(stuId, tracId, page, pstmt);
        pstmt.setDate(4, date);
        pstmt.execute();
    }

    public static void enterNewRow(int stuId, int tracId, int page) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(CREATE_NEW_ROW_WITHOUT_DATE);
        setStuTracPage(stuId, tracId, page, pstmt);
        pstmt.execute();
    }

    private static void setStuTracPage(int stuId, int tracId, int page, PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, stuId);
        pstmt.setInt(2, tracId);
        pstmt.setInt(3, page);
    }
}
