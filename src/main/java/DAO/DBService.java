package DAO;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DBService {
    private final Connection connection;
    private static DBService instance;

    private DBService() {
        this.connection = getH2Connection();
    }

    public static DBService getInstance() throws ClassNotFoundException {
        if (instance == null) {
            Class.forName("org.h2.Driver");
            instance = new DBService();
        }
        return instance;
    }

    public void executeUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuesry(String query) {
        try (Statement statement = connection.createStatement()){
            statement.executeQuery(query);
            return statement.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    private Connection getH2Connection() {
        try {
            String url = "jdbc:h2:tcp://localhost/~/test";
            String name = "tully";
            String pass = "tully";

            return DriverManager.getConnection(url, name, pass);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
