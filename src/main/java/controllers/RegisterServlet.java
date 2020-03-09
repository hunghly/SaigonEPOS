package controllers;

import dao.DaoFactory;
import dao.Users;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/register/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = (String) request.getParameter("username");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
//        System.out.println(username);
//        System.out.println(email);
//        System.out.println(password);
        try {
            Users userSQLDao = DaoFactory.getUsersSQLDao();
            if (userSQLDao.findUser(username) != null) {
                request.getSession().setAttribute("regDuplicate", true);
                request.getRequestDispatcher("/WEB-INF/register/register.jsp").forward(request, response);
                return;
            }
            String hash = BCrypt.hashpw(password, BCrypt.gensalt());
            userSQLDao.insert(new User(username, hash, email));
            request.getRequestDispatcher("/index").forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }







    }
}
