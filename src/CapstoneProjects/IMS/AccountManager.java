package CapstoneProjects.IMS;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts = new TreeSet<Account>();

    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    public Account login(String email, String password) throws InvalidAuthenticationException {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if(account.user.email.equals(email) && account.user.password.equals(password)) {
                account.setAuthenticationStatus(AuthenticationStatus.SUCCESS);
                account.user.lastLogin = new Date();
                return account;
            }
        }
        throw new InvalidAuthenticationException();
    }
}
