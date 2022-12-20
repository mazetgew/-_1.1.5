package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
    Connection connection = getConnection();

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS users(    ID INT AUTO_INCREMENT PRIMARY KEY,    NAME VARCHAR(30) NOT NULL,    LASTNAME VARCHAR(30) NOT NULL,    AGE TINYINT DEFAULT 0)";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropTable = "drop table if exists users;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUser = "INSERT INTO users (NAME, LASTNAME, AGE) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(saveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String removeByID = "DELETE FROM users WHERE ID = " + id;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(removeByID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String getAll = "SELECT * FROM users;";
        List<User> userList = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(getAll);
            userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String cleanTable = "TRUNCATE TABLE users;";

        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(cleanTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
