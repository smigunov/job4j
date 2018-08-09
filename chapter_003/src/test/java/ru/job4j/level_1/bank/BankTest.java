package ru.job4j.level_1.bank;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class BankTest {
    @Test
    public void testGetUserAccounts() {
        Bank bank = new Bank();
        User usr1 = new User("name1", "passport1");
        bank.addUser(usr1);
        Account acc1 = new Account("req1", 10);
        bank.addAccountToUser("passport1", acc1);
        Account acc12 = new Account("req12", 110);
        bank.addAccountToUser("passport1", acc12);
        User usr2 = new User("name2", "passport2");
        bank.addUser(usr2);
        Account acc2 = new Account("req2", 20);
        bank.addAccountToUser("passport2", acc2);
        assertThat(bank.getUserAccounts("passport1").size(), is(2));
    }

    @Test
    public void testDeleteAccountFromUser() {
        Bank bank = new Bank();
        User usr1 = new User("name1", "passport1");
        bank.addUser(usr1);
        Account acc1 = new Account("req1", 10);
        bank.addAccountToUser("passport1", acc1);
        Account acc12 = new Account("req12", 110);
        bank.addAccountToUser("passport1", acc12);
        bank.deleteAccountFromUser("passport1", acc1);
        assertThat(bank.getUserAccounts("passport1").size(), is(1));
    }

    @Test
    public void transferWhenUserIsNotFoundThenFalse() {
        Bank bank = new Bank();
        boolean result = bank.transferMoney("p1", "r1", "p2", "r2", 10);
        assertThat(result, is(false));
    }

    @Test
    public void transferWhenAccountIsNotFoundThenFalse() {
        Bank bank = new Bank();
        User usrSrc = new User("nameSrc", "passportSrc");
        User usrDst = new User("nameDst", "passportDst");
        bank.addUser(usrSrc);
        bank.addUser(usrDst);
        boolean result = bank.transferMoney("passportSrc", "r1", "passportDst", "r2", 10);
        assertThat(result, is(false));
    }

    @Test
    public void transferWhenNotEnoughMoneyThenFalse() {
        Bank bank = new Bank();
        User usrSrc = new User("nameSrc", "passportSrc");
        User usrDst = new User("nameDst", "passportDst");
        Account accSrc = new Account("reqSrc", 0);
        Account accDst = new Account("reqDst", 0);
        bank.addUser(usrSrc);
        bank.addUser(usrDst);
        bank.addAccountToUser("passportSrc", accSrc);
        bank.addAccountToUser("passportDst", accDst);
        boolean result = bank.transferMoney("passportSrc", "reqSrc", "passportDst", "reqDst", 10);
        assertThat(result, is(false));
    }

    @Test
    public void transferWhenEverythingIsCorrectThenTrue() {
        Bank bank = new Bank();
        User usrSrc = new User("nameSrc", "passportSrc");
        User usrDst = new User("nameDst", "passportDst");
        Account accSrc = new Account("reqSrc", 10);
        Account accDst = new Account("reqDst", 0);
        bank.addUser(usrSrc);
        bank.addUser(usrDst);
        bank.addAccountToUser("passportSrc", accSrc);
        bank.addAccountToUser("passportDst", accDst);
        boolean result = bank.transferMoney("passportSrc", "reqSrc", "passportDst", "reqDst", 10);
        assertThat(result, is(true));
    }

    @Test
    public void checkAccountSaldosAfterTransfer() {
        Bank bank = new Bank();
        User usrSrc = new User("nameSrc", "passportSrc");
        User usrDst = new User("nameDst", "passportDst");
        Account accSrc = new Account("reqSrc", 100);
        Account accDst = new Account("reqDst", 0);
        bank.addUser(usrSrc);
        bank.addUser(usrDst);
        bank.addAccountToUser("passportSrc", accSrc);
        bank.addAccountToUser("passportDst", accDst);
        boolean result = bank.transferMoney("passportSrc", "reqSrc", "passportDst", "reqDst", 10);
        double etalonSaldoSrc = 90;
        double etalonSaldoDst = 10;
        assertThat(accSrc.getValue(), is(etalonSaldoSrc));
        assertThat(accDst.getValue(), is(etalonSaldoDst));
    }
}