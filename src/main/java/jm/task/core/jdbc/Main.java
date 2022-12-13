package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("gay1", "gay", (byte) 100);
        userDao.saveUser("gay2", "gay", (byte) 100);
        userDao.saveUser("gay3", "gay", (byte) 100);
        userDao.saveUser("gay4", "gay", (byte) 100);
        userDao.saveUser("gay5", "gay", (byte) 100);
        userDao.getAllUsers();
        System.out.println("______________________________________________________");
        userDao.removeUserById(2);
        userDao.removeUserById(5);
        userDao.getAllUsers();
        System.out.println("______________________________________________________");
        userDao.cleanUsersTable();
        userDao.getAllUsers();
        System.out.println("______________________________________________________");
        userDao.dropUsersTable();
    }
}