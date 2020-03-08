package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {

    /*CRUD Functions*/
    // Read all users and create a list
    List<User> all();

    // Create - insert user into database
    int insert(User user) throws SQLException;

    // Read - finding user by username
    User findUser(String username);

    // Update - updating user based off username
    boolean updateUser(String username, User user);

    // Delete - delete user based on username
    boolean deleteUser(String username);
}
