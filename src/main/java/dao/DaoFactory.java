package dao;

import java.sql.SQLException;

public class DaoFactory {
    private static Users usersSQLDao;
    private static Foods foodsSQLDao;
    private static Config config = new Config();

    public static Users getUsersSQLDao() throws SQLException {
        if (usersSQLDao == null) {
            usersSQLDao = new UsersSQLDao(config);
        }
        return usersSQLDao;
    }

    public static Foods getFoodsSQLDao() throws SQLException {
        if (foodsSQLDao == null) {
            foodsSQLDao = new FoodSQLDao(config);
        }
        return foodsSQLDao;
    }

}
