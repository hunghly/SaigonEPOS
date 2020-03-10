package dao;

import com.mysql.cj.jdbc.Driver;
import models.Food;

import java.sql.*;
import java.util.List;

public class FoodSQLDao implements Foods {
    Connection connection;

    public FoodSQLDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }

    @Override
    public List<Food> all() {
        return null;
    }

    @Override
    public int insert(Food food) throws SQLException {
        String sqlQuery = "INSERT INTO foods (name, price, img_url, user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, food.getName());
        stmt.setDouble(2, food.getPrice());
        stmt.setString(3, food.getImgUrl());
        stmt.setInt(4, food.getUserId());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public Food findFood(String name) {
        return null;
    }

    @Override
    public boolean updateFood(String name, Food food) {
        return false;
    }

    @Override
    public boolean deleteFood(String name) {
        return false;
    }
}
