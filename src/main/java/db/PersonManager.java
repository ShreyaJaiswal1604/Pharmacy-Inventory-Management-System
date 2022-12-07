package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class PersonManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static boolean createUser() throws Exception {
        boolean isInserted = true;
        try {
            String query = "INSERT INTO user(username, password, role)"
                            + "values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "Barney Rubble");
            preparedStmt.setString (2, "password");
            preparedStmt.setString (3, "pharmacy_admin");
            preparedStmt.execute();
            return isInserted;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static boolean verifyUser() throws Exception {
        boolean isValidUser = true;
        try {
            String name = "Barney Rubble";
            String password = "password";
            String query = String.format("SELECT username, password FROM user WHERE username=\"%s\"", name);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) {
                if (password.equals(rs.getString("password"))) return isValidUser;
                else throw new Exception("Invalid Password");
            } else throw new Exception("Invalid Username");
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static boolean deleteUser() throws Exception {
        boolean isValidUser = true;
        try {
            String query = "DELETE FROM user WHERE username=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "Barney Rubble");
            preparedStmt.execute();
            return isValidUser;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static boolean updateUser() throws Exception {
        boolean isInserted = true;
        try {
            String query = "UPDATE user SET username=?, role)"
                            + "values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "Barney Rubble");
            preparedStmt.setString (2, "password");
            preparedStmt.setString (3, "pharmacy_admin");
            preparedStmt.execute();
            return isInserted;
        } catch (SQLException e) {
            throw e;
        }
    }
}
