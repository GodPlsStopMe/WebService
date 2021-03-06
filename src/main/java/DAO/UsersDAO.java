package DAO;

import data.UserData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO {
    private DBService dbService;

    private UsersDAO() {
        try {
            this.dbService = DBService.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static UsersDAO instance;

    public static UsersDAO getInstance() {
        if (instance == null) {
            instance = new UsersDAO();
        }
        return instance;
    }


    public UserData getUserByLogin(String login) {
        String query = ("select * from users where name=" + login);
        ResultSet resultSet = dbService.executeQuesry(query);
        UserData userData = null;
        try {
            userData = new UserData(resultSet.getLong("ID"), resultSet.getString("LOGIN"), resultSet.getString("PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;

    }

    public void insertUserInDB(UserData userData) {
        String update = ("INSERT INTO USERS VALUES (default, '" + userData.getName() + "','" + userData.getPassword() + "'); ");
        dbService.executeUpdate(update);
    }

    public ArrayList<UserData> reloadUsersFromDB() {
        String query = ("select * from users");
        ResultSet resultSet = dbService.executeQuesry(query);
        ArrayList<UserData> result = new ArrayList<>();
        UserData userData = null;
        try {
            while (resultSet.next()) {
                userData = new UserData(
                        resultSet.getLong("ID"),
                        resultSet.getString("LOGIN"),
                        resultSet.getString("PASSWORD"));
                result.add(userData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

