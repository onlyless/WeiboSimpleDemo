package DAO;

import model.User;

import java.util.List;

public interface RelationDAO {
    List<User> getFans(User user);

    List<User> getFollows(User user);
}
