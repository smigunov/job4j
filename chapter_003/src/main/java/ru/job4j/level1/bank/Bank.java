package ru.job4j.level1.bank;

import java.util.*;
import java.util.function.Consumer;

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
        this.userAccounts.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findFirst().get().getValue().remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.userAccounts.entrySet().stream().filter(entry -> entry.getKey().getPassport().equals(passport)).findFirst().get().getValue();
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        return this.userAccounts.entrySet().stream().filter(entry -> entry.getKey().getPassport().equals(srcPassport)).findFirst().map(
            entry -> entry.getValue().stream().filter(acc -> (srcRequisite.equals(acc.getReqs()) && acc.getValue() >= amount)).findFirst().map(
                srcAcc -> {
                    return this.userAccounts.entrySet().stream().filter(entryDst -> entryDst.getKey().getPassport().equals(dstPassport)).findFirst().map(
                                entryDst -> {
                                    return entryDst.getValue().stream().filter(acc -> dstRequisite.equals(acc.getReqs())).findFirst().map(
                                        dstAcc ->{
                                            srcAcc.setValue(srcAcc.getValue() - amount);
                                            dstAcc.setValue(dstAcc.getValue() + amount);
                                            return true;
                                        }
                                    ).orElseGet(()->{return false;});
                                }
                        ).orElseGet(()->{return false;});
                }
            ).orElseGet(()->{return false;})
        ).orElseGet(()->{return false;});
    }

}
