package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Gera1", "Gera", (byte) 100);
        System.out.println("User с именем – Gera1 добавлен в базу данных");
        userService.saveUser("Gera2", "Gera", (byte) 100);
        System.out.println("User с именем – Gera2 добавлен в базу данных");
        userService.saveUser("Gera3", "Gera", (byte) 100);
        System.out.println("User с именем – Gera3 добавлен в базу данных");
        userService.saveUser("Gera4", "Gera", (byte) 100);
        System.out.println("User с именем – Gera4 добавлен в базу данных");
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        userService.removeUserById(2);
        System.out.println("User с именем – Gera2 удалён из базы данных");
        userService.removeUserById(3);
        System.out.println("User с именем – Gera3 удалён из базы данных");
        userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        userService.cleanUsersTable();
        System.out.println("Таблица очищена");
        userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("______________________________________________________");
        System.out.println("Таблица удалена");
        userService.dropUsersTable();
    }
}