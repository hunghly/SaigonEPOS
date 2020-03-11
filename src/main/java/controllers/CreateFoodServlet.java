package controllers;

import dao.DaoFactory;
import models.Food;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/food/create")
public class CreateFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/foods/createFood.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        User user = (User) request.getSession().getAttribute("user");

        try {
            if (DaoFactory.getFoodsSQLDao().insert(new Food(name, price, "", user.getId())) != 0) {
                request.getSession().setAttribute("foodCreated", true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/food/create");
    }
}
