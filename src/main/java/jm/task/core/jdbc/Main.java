package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Util util = new Util();
      util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Pavel", "Datsuk", Byte.parseByte("46"));
        userDao.saveUser("Alexander", "Ovechkin", Byte.parseByte("40"));
        userDao.saveUser("Pavel", "Bure", Byte.parseByte("52"));
        userDao.saveUser("Alexey", "Yashin", Byte.parseByte("49"));
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
