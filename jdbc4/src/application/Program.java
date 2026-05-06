package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main (String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement("DELETE FROM department "
            + "WHERE "
            + "Id = ?");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();

            IO.println("Terminou! Linhas afetadas: " + rowsAffected);
        } catch (SQLException err) {
            throw new DbIntegrityException(err.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
