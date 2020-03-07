package dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect("/WEB-INF/register/register.jsp");
        request.getRequestDispatcher("/WEB-INF/register/register.jsp").forward(request,response);
    }
}
