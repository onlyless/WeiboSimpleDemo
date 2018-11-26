package DAO.DAOImpl;

import DAO.UserDAO;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJdbcImpl implements UserDAO {
    private DataSource dataSource;

    public UserDAOJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getUsers(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        List<User> users = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ? ORDER BY date");
            stmt.setString(1,user.getUsername());
            ResultSet rs = stmt.executeQuery();
            users = new ArrayList<>();
            while(rs.next()){
                String date = rs.getString("date");
                date = date.substring(0,date.indexOf("."));
                users.add(new User(rs.getString("id"),user.getUsername(),date,rs.getString
                        ("message")));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("INSERT INTO user(id,username,date,message) VALUES (?,?,?,?)");
            stmt.setString(1,user.getId());
            stmt.setString(2,user.getUsername());
            stmt.setString(3,user.getDate());
            stmt.setString(4,user.getTxt());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("DELETE FROM user WHERE id=?");
            stmt.setString(1,user.getId());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
