package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException{
        if(connection == null){
            String connectionString = PropertyUtil.getPropertyString("C:\\Users\\vibho\\IdeaProjects\\Insurance\\src\\util\\db.properties");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(connectionString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
        }
    }
