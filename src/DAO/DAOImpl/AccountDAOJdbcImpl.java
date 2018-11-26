package DAO.DAOImpl;

import DAO.AccountDAO;
import model.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOJdbcImpl implements AccountDAO {
    private DataSource dataSource;

    public AccountDAOJdbcImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUserExisted(Account account) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        boolean existed = false;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM account WHERE username=?");
            stmt.setString(1,account.getName());
//            System.out.println(account.getName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                existed = true;
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            exception = e;
        }finally {
        }

        return existed;
    }

    @Override
    public void addAccount(Account account) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("INSERT INTO account(id,email,username,password) VALUES (?,?,?,?)");
            stmt.setString(1,account.getId());
            stmt.setString(2,account.getEmail());
            stmt.setString(3,account.getName());
            stmt.setString(4,account.getPassword());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(Account account) {
        Connection connection = null;
        PreparedStatement stmt = null;
        SQLException exception = null;
        Account acct = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM account WHERE username = ?");
            stmt.setString(1,account.getName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                acct = new Account(rs.getString("id"),rs.getString("email"),account.getName(),rs.getString
                        ("password"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acct;
    }
}
