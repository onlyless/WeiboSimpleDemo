package DAO;

import model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers(User user);
    void addUser(User user);
    void deleteUser(User user);
}
