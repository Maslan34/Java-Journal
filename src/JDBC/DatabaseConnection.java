package JDBC;

import java.sql.*;

public class DatabaseConnection {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "12345";

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL database");
                st = conn.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM student_schema.student");
                while (resultSet.next()) {
                    System.out.println("ID : " + resultSet.getInt("id"));
                    System.out.println("Name : " + resultSet.getString("first_name"));
                    System.out.println("Last Name : " + resultSet.getString("last_name"));
                    System.out.println("Birth Date : " + resultSet.getDate("date_birth"));
                    System.out.println("#################");
                }


                // Statement ile Insert İşlemi
                String updateQuery = "INSERT INTO student_schema.student (first_name,last_name,date_birth) VALUES ('Barış' , 'Manço' , '1990-05-22')";
                st.executeUpdate(updateQuery);

                // PreparedStatement ile Insert İşlemi
                PreparedStatement pr = conn.prepareStatement("INSERT INTO student_schema.student (first_name,last_name,date_birth) VALUES (?,?,CAST(? AS TIMESTAMP))");
                pr.setString(1, "Müslüm");
                pr.setString(2, "Gürses");
                pr.setString(3, "1980-02-23");
                pr.executeUpdate();

                st.close();
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database");
            throw new RuntimeException(e);
        }

    }


}
