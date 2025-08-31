package JDBC;

import java.sql.*;

public class DatabaseTransaction {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "12345";

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        /*
        The applications we develop may sometimes perform operations on one or more tables with a single process call,
        or require running one or more queries sequentially.
        In such cases, if an error occurs in one of the queries during these sequential operations,
        we may want to roll back the other operations as well.
        Manually going through the tables and undoing the changes we made in such situations would be quite difficult and complex.

         */


        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            conn.setAutoCommit(false);
            // Insert Operation with PreparedStatement
            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (student_fname,student_lname,student_class) VALUES (?,?,?)");
            pr.setString(1, "Harry");
            pr.setString(2, "Potter");
            pr.setString(3, "2");
            pr.executeUpdate();

            if (1 == 1) {
                throw new SQLException();
            }

            // Insert Operation with PreparedStatement
            pr.setString(1, "Ron");
            pr.setString(2, "Weasley");
            pr.setString(3, "1");
            pr.executeUpdate();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}


