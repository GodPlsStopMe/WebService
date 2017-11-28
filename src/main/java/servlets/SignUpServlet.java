package servlets;

import DAO.UsersDAO;
import data.UserData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String userName = req.getParameter("login");
        UserData userData = new UserData(userName, password);
        UsersDAO.getInstance().insertUserInDB(userData);
        UsersDAO.getInstance().reloadUsersFromDB();
    }
}
