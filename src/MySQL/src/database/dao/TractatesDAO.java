package database.dao;

import database.DB_Connection;
import io.PrintToScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TractatesDAO {
    private static final String DOES_PAGE_EXIST_QUERY =
            "SELECT COUNT(*) FROM tractates WHERE id = ? AND pages >= ?";
    static Connection conn = DB_Connection.getConnection();
    private static final String DOES_TRACTATE_EXIST_QUERY = "SELECT COUNT(*) FROM tractates WHERE name = ?";
    private static final String DISPLAY_ALL_TRACS_QUERY = "SELECT * FROM tractates";
    private static final String INSERT_NEW_TRACTATE =
            "INSERT INTO tractates(name, pages) " +
                    "VALUES(?, ?)";
    private static final String DISPLAY_ONE_TRACTATE_QUERY =
            "SELECT * FROM tractates WHERE name = ?";
    private static final String GET_TRACTATE_ID_QUERY =
            "SELECT id FROM tractates WHERE name = ?";

    public static void displayAllTracs() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DISPLAY_ALL_TRACS_QUERY);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            PrintToScreen.displayTrac(rset.getString(2), rset.getInt(3));
        }
    }

    public static boolean doesTracExist(String tracName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DOES_TRACTATE_EXIST_QUERY);
        pstmt.setString(1, tracName);
        ResultSet rset = pstmt.executeQuery();
        int count = -1;
        while(rset.next()) {count = rset.getInt(1);}
        return count > 0;
    }

    public static void addTracToDB(String tracName, int tracPages) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(INSERT_NEW_TRACTATE);
        pstmt.setString(1, tracName);
        pstmt.setInt(2, tracPages);
        pstmt.execute();
    }

    public static void displayOneTrac(String tracName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DISPLAY_ONE_TRACTATE_QUERY);
        pstmt.setString(1, tracName);
        ResultSet rset = pstmt.executeQuery();
        while(rset.next())
            PrintToScreen.displayTrac(rset.getString(2), rset.getInt(3));

    }

    public static int getTractateId(String trac) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(GET_TRACTATE_ID_QUERY);
        pstmt.setString(1, trac);
        ResultSet rset = pstmt.executeQuery();
        while(rset.next())return rset.getInt(1);
        return -1;
    }

    public static boolean isPageValid(int tracId, int page) throws SQLException {
        if(page < 1) return false;
        PreparedStatement pstmt = conn.prepareStatement(DOES_PAGE_EXIST_QUERY);
        pstmt.setInt(1, tracId);
        pstmt.setInt(2, page);
        ResultSet rset = pstmt.executeQuery();
        while(rset.next()) return rset.getInt(1) > 0;
        return false;
    }
}

