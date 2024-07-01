package jm.task.core.jdbc.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
//   public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
//    public static final String USERNAME = "root1";
//    public static final String PASSWORD = "root1";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String URL = null;
        String USERNAME = null;
        String PASSWORD = null;
        String DRIVER = null;

        FileInputStream fis;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("src/main/java/resources/config.properties");
            properties.load(fis);
            URL = properties.getProperty("db.host");
            USERNAME = properties.getProperty("db.username");
            PASSWORD = properties.getProperty("db.password");
            DRIVER = properties.getProperty("db.driver");
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }

        Connection connection = null;
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
