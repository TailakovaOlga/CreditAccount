package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SavingAccountTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ValidData.csv")
    public void shouldSavingAccountWithValidData(int initialBalance, int minBalance, int maxBalance, int rate, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidData.csv")
    public void shouldNotSavingAccountWithInvalidData(int initialBalance, int minBalance, int maxBalance, int rate) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new SavingAccount(initialBalance, minBalance, maxBalance, rate));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/AddValidData.csv")
    public void shouldAddWithValidData(int initialBalance, int minBalance, int maxBalance, int rate, int amount, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        account.add(amount);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/AddInvalidData.csv")
    public void shouldNotAddWithInvalidData(int initialBalance, int minBalance, int maxBalance, int rate, int amount, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        account.add(amount);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/PayValidData.csv")
    public void shouldPayWithValidData(int initialBalance, int minBalance, int maxBalance, int rate, int amount, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        account.pay(amount);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/PayInvalidData.csv")
    public void shouldNotPayWithInvalidData(int initialBalance, int minBalance, int maxBalance, int rate, int amount, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        account.pay(amount);
        Assertions.assertEquals(expected, account.getBalance());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/YearChangeData.csv")
    public void shouldYearChangeWithValidData(int initialBalance, int minBalance, int maxBalance, int rate, int expected) {
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        Assertions.assertEquals(expected, account.yearChange());
    }

}
