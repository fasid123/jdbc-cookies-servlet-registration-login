package logincheckmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logincheckmvc.model.Person;
import logincheckmvc.util.Db;

public class PersonDao {

    public boolean validate(String username, String password) {
        String sql = "SELECT * FROM person WHERE username=? AND password=?";

        try (Connection con = Db.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            return rs.next();   // true if user exists

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(Person p) {
        String sql = "INSERT INTO person VALUES (?,?,?,?,?)";

        try (Connection con = Db.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, p.getName());
            pst.setString(2, p.getEmail());
            pst.setString(3, p.getMobile());
            pst.setString(4, p.getUsername());
            pst.setString(5, p.getPassword());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
