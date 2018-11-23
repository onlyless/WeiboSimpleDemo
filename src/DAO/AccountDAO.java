package DAO;

import model.Account;

public interface AccountDAO {
    boolean isUserExisted(Account account);
    void addAccount(Account account);
    Account getAccount(Account account);
}
