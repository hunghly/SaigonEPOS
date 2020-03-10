package dao;

import models.Food;
import models.User;

import java.sql.SQLException;
import java.util.List;

public interface Foods {

    List<Food> all();

    // Create - insert food into database
    int insert(Food food) throws SQLException;

    // Read - finding food by name
    Food findFood(String name);

    // Update - updating food based off  name
    boolean updateFood(String name, Food food);

    // Delete - delete food based on name
    boolean deleteFood(String name);

}
