package Service;

import DAO.AccountDAO;
import DAO.UserDAO;
import model.Account;
import model.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private AccountDAO accountDAO;
    private UserDAO userDAO;
    private LinkedList<User> newest = new LinkedList<>();

    public UserService(AccountDAO accountDAO,UserDAO userDAO){
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
    }

    public boolean isUserExisted(Account account){
        return accountDAO.isUserExisted(account);
    }

    public void add(Account account){
        accountDAO.addAccount(account);
    }

    public boolean checkLogin(Account account){
        if(account.getName()!=null && account.getPassword() != null){
            Account storeAcct = accountDAO.getAccount(account);
            return storeAcct != null && storeAcct.getPassword().equals(account.getPassword());
        }
        return false;
    }

    public List<User> getUsers(User user){
        List<User> users = userDAO.getUsers(user);
        return users;
    }

    public void addUser(User user){
        userDAO.addUser(user);
        newest.addFirst(user);
        if(newest.size()>20){
            newest.removeLast();
        }
    }

    public void delUser(User user){
        userDAO.deleteUser(user);
        newest.remove(user);
    }

    public List<User> getNewest(){
        return newest;
    }

}
