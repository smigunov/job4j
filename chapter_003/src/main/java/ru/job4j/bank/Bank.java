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


    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = true;
        try {
            User srcUser = getUser(srcPassport);
            if (srcUser == null) {
                throw new IllegalStateException("Source user not found");
            }
            Account srcAccount = getAccount(this.userAccounts.get(srcUser), srcRequisite);
            if (srcAccount == null) {
                throw new IllegalStateException("Source account not found");
            }
            if (srcAccount.getValue() < amount) {
                throw new IllegalStateException("Not enough money");
            }
            User dstUser = getUser(dstPassport);
            if (dstUser == null) {
                throw new IllegalStateException("Destination user not found");
            }
            Account dstAccount = getAccount(this.userAccounts.get(dstUser), dstRequisite);
            if (dstAccount == null) {
                throw new IllegalStateException("Destination account not found");
            }

            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
        } catch (IllegalStateException ise) {
            result = false;
        }
        return result;
    }

}
