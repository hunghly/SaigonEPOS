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

@WebServlet(urlPatterns = {"/", "/index"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Users user = DaoFactory.getUsersSQLDao();
            User foundUser = user.findUser(username);
            if (foundUser != null) {
                if (BCrypt.checkpw(password, foundUser.getPassword())) {
                    response.sendRedirect("/home");
                    return;
                }
            }
            request.getSession().setAttribute("invalid", true);
            response.sendRedirect("/index");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
