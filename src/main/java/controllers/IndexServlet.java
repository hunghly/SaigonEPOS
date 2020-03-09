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

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("regDuplicate");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Users user = DaoFactory.getUsersSQLDao();
            User foundUser = user.findUser(username);
            if (foundUser == null) {
                // need to add check to see if user's password does not equal
                request.getSession().setAttribute("invalid", true);
                request.getRequestDispatcher("/index").forward(request,response);
                return;
            }
            if (BCrypt.checkpw(password, foundUser.getPassword())) {
                request.getRequestDispatcher("/");
                return;
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }
}
