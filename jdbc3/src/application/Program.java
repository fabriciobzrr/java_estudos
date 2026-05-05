package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main (String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "update seller "
                    + "set BaseSalary = BaseSalary + ? "
                    + "where "
                    + "(DepartmentId = ?)");

            st.setDouble(1, 450.0);
            st.setInt(2, 1);

            int rowsAffected = st.executeUpdate();

            IO.println("Terminou! Linhas afetadas: " + rowsAffected);
        } catch (SQLException err) {
            err.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
