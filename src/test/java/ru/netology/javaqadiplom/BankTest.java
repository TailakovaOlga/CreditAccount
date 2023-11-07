package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Account;
import ru.netology.javaqadiplom.Bank;
import ru.netology.javaqadiplom.SavingAccount;

public class BankTest {

    @Test
    public void shouldTransferIfAmountValid() {
        Account from = new SavingAccount(300, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 1);
        Assertions.assertEquals(299, from.getBalance());
        Assertions.assertEquals(401, to.getBalance());
    }

    @Test
    public void shouldTransferIfAmountNegative() {
        Account from = new SavingAccount(300, 0, 5000, 0);
        Account to = new SavingAccount(400, 0, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, -1);
        Assertions.assertEquals(300, from.getBalance());
        Assertions.assertEquals(400, to.getBalance());
    }

    @Test
    public void shouldTransferIfAmountNull() {
        Account from = new SavingAccount(500, 0, 5000, 0);
        Account to = new SavingAccount(400, 0, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 0);
        Assertions.assertEquals(500, from.getBalance());
        Assertions.assertEquals(400, to.getBalance());
    }

    @Test
    public void shouldTransferIfBalanceFromMoreMinBalance() {
        Account from = new SavingAccount(300, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 299);
        Assertions.assertEquals(1, from.getBalance());
        Assertions.assertEquals(699, to.getBalance());
    }

    @Test
    public void shouldTransferIfBalanceFromLessMinBalance() {
        Account from = new SavingAccount(300, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 301);
        Assertions.assertEquals(300, from.getBalance());
        Assertions.assertEquals(400, to.getBalance());
    }

    @Test
    public void shouldTransferIfBalanceFromEqualMinBalance() {
        Account from = new SavingAccount(300, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 300);
        Assertions.assertEquals(0, from.getBalance());
        Assertions.assertEquals(700, to.getBalance());
    }


    @Test
    public void shouldTransferIfBalanceToMoreMaxBalance() {
        Account from = new SavingAccount(800, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 601);
        Assertions.assertEquals(800, from.getBalance());
        Assertions.assertEquals(400, to.getBalance());
    }

    @Test
    public void shouldTransferIfBalanceToEqualMaxBalance() {
        Account from = new SavingAccount(800, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 600);
        Assertions.assertEquals(200, from.getBalance());
        Assertions.assertEquals(1000, to.getBalance());
    }

    @Test
    public void shouldTransferIfBalanceToLessMaxBalance() {
        Account from = new SavingAccount(800, 0, 5000, 0);
        Account to = new SavingAccount(400, 5, 1000, 0);
        Bank bank = new Bank();
        bank.transfer(from, to, 599);
        Assertions.assertEquals(201, from.getBalance());
        Assertions.assertEquals(999, to.getBalance());
    }


}
