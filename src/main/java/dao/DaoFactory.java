package dao;

import java.sql.SQLException;

public class DaoFactory {
    private static Users usersSQLDao;
    private static Config config = new Config();

    public static Users getUsersSQLDao() throws SQLException {
        if (usersSQLDao == null) {
            usersSQLDao = new UsersSQLDao(config);
        }
        return usersSQLDao;
    }
}
