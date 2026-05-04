package application;

import db.DB;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main (String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                            "VALUES" +
                            "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Robert Green");
            st.setString(2, "robert@mail.com");
            st.setDate(3, java.sql.Date.valueOf(LocalDate.parse("10/11/1985", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            st.setDouble(4, 5000);
            st.setInt(5, 4);

            st = conn.prepareStatement("insert into department (Name) values ('Technology'),('Cyber Security'),('DevOps')", Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    IO.println("ID: " + id);
                }
            } else {
                IO.println("Nenhuma linha afetada!");
            }
        } catch (SQLException err) {
            err.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
