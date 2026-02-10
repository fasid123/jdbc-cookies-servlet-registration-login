package logincheckmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/logindb";
        String user = "root";
        String pass = "fasid123";
        return DriverManager.getConnection(url, user, pass);
    }
}
