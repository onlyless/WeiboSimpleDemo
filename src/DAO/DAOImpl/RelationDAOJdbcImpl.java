package DAO.DAOImpl;

import DAO.RelationDAO;
import model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationDAOJdbcImpl implements RelationDAO {
    DataSource dataSource;

    public RelationDAOJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getFans(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        List<User> fans = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("SELECT DISTINCT a2.id,a2.username FROM relation,account a1, account " +
                    "a2 " +
                    "WHERE relation.uid_from=a1.id AND a1.username=? AND relation.uid_to=a2.id");
            stmt.setString(1,user.getUsername());
            ResultSet rs = stmt.executeQuery();
            fans = new ArrayList<>();
            while(rs.next()){
                User fan = new User();
                fan.setId(rs.getString("id"));
                fan.setUsername(rs.getString("username"));
                fans.add(fan);
            }
            stmt.close();
            connection.close();
            return fans;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fans;
    }

    @Override
    public List<User> getFollows(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("SELECT a2.id,a2.username FROM account a1,account a2,relation WHERE " +
                    "relation.uid_from=a2.id AND relation.uid_to=a1.id AND a1.username=?");
            stmt.setString(1,user.getUsername());
            ResultSet rs = stmt.executeQuery();
            List<User> follows = new ArrayList<>();
            while(rs.next()){
                User follow = new User();
                follow.setId(rs.getString("id"));
                follow.setUsername(rs.getString("username"));
                follows.add(follow);
            }
            stmt.close();
            connection.close();
            return follows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
