

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getH2Connection();
    }

    public void executUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuesry(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            statement.close();
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

            return getConnection(url, name, pass);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
