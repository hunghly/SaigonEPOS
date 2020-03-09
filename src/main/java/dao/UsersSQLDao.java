package dao;

import com.mysql.cj.jdbc.Driver;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.List;

public class UsersSQLDao implements Users{
    Connection connection;

    public UsersSQLDao (Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public int insert(User user) throws SQLException {
        String sqlQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        PreparedStatement stmt = this.connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getEmail());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public User findUser(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            if (!rs.next()) {
                return null;
            }
            return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public boolean updateUser(String username, User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        return false;
    }

    public static void main(String[] args) throws SQLException {
        Users usersSQLDao = DaoFactory.getUsersSQLDao();
        User hung = new User("hung", "123","hung@email.com");
        User bob = new User("bobbby", "123", "bobbby@email.com");
//        System.out.println(usersSQLDao.insert(bob));
        System.out.println(usersSQLDao.findUser("hung"));
    }
}
