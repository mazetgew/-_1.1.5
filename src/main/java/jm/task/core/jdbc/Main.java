package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Gera1", "Gera", (byte) 100);
        System.out.println("User с именем – Gera1 добавлен в базу данных");
        userDao.saveUser("Gera2", "Gera", (byte) 100);
        System.out.println("User с именем – Gera2 добавлен в базу данных");
        userDao.saveUser("Gera3", "Gera", (byte) 100);
        System.out.println("User с именем – Gera3 добавлен в базу данных");
        userDao.saveUser("Gera4", "Gera", (byte) 100);
        System.out.println("User с именем – Gera4 добавлен в базу данных");
        List<User> userList = userDao.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        userDao.removeUserById(2);
        System.out.println("User с именем – Gera2 удалён из базы данных");
        userDao.removeUserById(3);
        System.out.println("User с именем – Gera3 удалён из базы данных");
        userList = userDao.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
        userList = userDao.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        System.out.println("Таблица удалена");
        userDao.dropUsersTable();
    }
}