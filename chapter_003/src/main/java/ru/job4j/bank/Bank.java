package ru.job4j.bank;
import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> listAcc = getUserAccounts(passport);
        if (listAcc != null) {
            if (!listAcc.contains(account)) {
                listAcc.add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> listAcc = getUserAccounts(passport);
        int idx = listAcc.indexOf(account);
        if (idx >= 0) {
            listAcc.remove(idx);
        }
    }

    private User getUser(String passport) {
        User resultUser = null;
        for (User user : this.userAccounts.keySet()) {
            if (passport.equals(user.getPassport())) {
                resultUser = user;
                break;
            }
        }
        return resultUser;
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        User user = getUser(passport);
        if (user != null) {
            result = this.userAccounts.get(user);
        }
        return result;
    }

    private Account getAccount(List<Account> listAcc, String reqs) {
        Account result = null;
        for (Account account : listAcc) {
            if (reqs.equals(account.getReqs())) {
                result = account;
            }
        }
        return result;
    }

    private Account getAccount(String passport, String requisite) {
        User user = getUser(passport);
        Account result = null;
        if (user != null) {
            result = getAccount(this.userAccounts.get(user), requisite);
        }
        return result;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account dstAccount = getAccount(dstPassport, dstRequisite);
        if ((srcAccount != null) && (dstAccount != null) && (srcAccount.getValue() >= amount)) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
            result = true;
        }
        return result;
    }

}
