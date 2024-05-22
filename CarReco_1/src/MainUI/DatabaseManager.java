package MainUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/findcar";
    private static final String USERNAME = "Pratik";
    private static final String PASSWORD = "9977";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        Boolean result = false;

       try{
          connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
          statement = connection.createStatement();
          result=true;
       }
          catch( SQLException e1)
          {
              //Do Something
              System.out.println("Connection error:"+e1);
              result = false;
          }
        return connection;
    }
   
}
