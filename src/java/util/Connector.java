package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
        
    public Connection connect() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hayvanatbahcesi?user=root&password=123654");
        //   System.out.println("Database Successfuly");

        } catch (SQLException e) {
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return connection;
    }

}
