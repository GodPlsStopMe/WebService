package UsersHolder;

import DAO.UsersDAO;
import data.UserData;

import java.util.ArrayList;
import java.util.HashMap;

public class UsersHolder {
    private ArrayList<UserData> users;
    private static UsersHolder instance;

    private UsersHolder() {
        users = UsersDAO.reloadUsersFromDB();

    }

    public static UsersHolder getInstance() {
        if (instance == null) {
            instance = new UsersHolder();
        }
        return instance;
    }
}
