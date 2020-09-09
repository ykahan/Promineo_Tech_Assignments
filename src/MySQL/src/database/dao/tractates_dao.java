package database.dao;

import database.DB_Connection;
import io.PrintToScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tractates_dao {
    static Connection conn;
    private static final String DOES_TRACTATE_EXIST_QUERY = "SELECT COUNT(*) FROM tractates WHERE name = ?";
    private static final String DISPLAY_ALL_TRACS_QUERY = "SELECT * FROM tractates";
    private static final String INSERT_NEW_TRACTATE =
            "INSERT INTO tractates(name, pages) " +
                    "VALUES(?, ?)";
    private static final String DISPLAY_ONE_TRACTATE_QUERY =
            "SELECT * FROM tractates WHERE name = ?";
    public tractates_dao() {
        conn = DB_Connection.getConnection();
    }

    public static void displayAllTracs() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(DISPLAY_ALL_TRACS_QUERY);
        ResultSet rset = pstmt.executeQuery();
        if (rset.next()) {
            PrintToScreen.displayTrac(rset.getString(1), rset.getInt(2));
        }
    }

    public static boolean doesTracExist(String tracName) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(DOES_TRACTATE_EXIST_QUERY);
        ResultSet rset = pstm.executeQuery();
        int count = rset.getInt(1);
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
            PrintToScreen.displayTrac(rset.getString(1), rset.getInt(2));

    }
}

