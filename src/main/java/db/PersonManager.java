package db;

import data.model.person.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class PersonManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static boolean createUser(Person p) throws Exception {
        boolean isInserted = true;
        try {
            String query = "INSERT INTO person(username, person_name, password, person_dob, person_gender, person_role, person_address, person_city, person_zip)"
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, p.getUsername());
            preparedStmt.setString (2, p.getPersonName());
            preparedStmt.setString (3, p.getPassword());
            preparedStmt.setString (4, p.getPersonDob().getFormattedDate());
            preparedStmt.setString (5, p.getPersonGender());
            preparedStmt.setString (6, p.getPersonRole());
            preparedStmt.setString (7, p.getLocation().address);
            preparedStmt.setString (8, p.getLocation().city);
            preparedStmt.setString (9, p.getLocation().zipcode);
            preparedStmt.execute();
            return isInserted;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static boolean verifyUser(String username, String password) throws Exception {
        boolean isValidUser = true;
        try {
            String query = String.format("SELECT username, password FROM person WHERE username=\"%s\"", username);
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
            String query = "DELETE FROM person WHERE username=?";
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
