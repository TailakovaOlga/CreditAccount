package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test //Пополнение на 3_000 при положительном балансе
    public void shouldReplenishmentPositiveBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test //Пополнение на 0 при положительном балансе
    public void shouldReplenishmentToZeroBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.add(0);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test //Пополнение на 0 при положительном балансе метод add
    public void shouldAddReplenishmentToZeroBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        Assertions.assertEquals(true, account.add(1));
    }

    @Test //Пополнение на отрицательное число
    public void shouldReplenishmentNegativeBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.add(-1);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test //Пополнение на отрицательное число метод add
    public void shouldAddReplenishmentNegativeBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.add(-1));
    }

    @Test //Покупка в рамках баланса
    public void shouldPayAmount() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );
        account.pay(2_000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test // Покупка превышающая лимит
    public void shouldWithinLimit() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(7_000);
        Assertions.assertEquals(-3_000, account.getBalance());
    }

    @Test // Покупка превышающая  баланс и лимит
    public void shouldBelowLimit() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(15_000);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test // Покупка равна 0
    public void shouldPayZero() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(0);
        Assertions.assertEquals(4000, account.getBalance());
    }

    @Test // Покупка равна сумме баланса и лимита
    public void shouldPayForAmountBalansAndLimit() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(9_000);
        Assertions.assertEquals(-5000, account.getBalance());
    }

    @Test // Покупка на отрицательное число
    public void shouldPayNegative() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(-1000);
        Assertions.assertEquals(4000, account.getBalance());
    }

    @Test // Исключение вида IllegalArgumentException для отрицательного баланса
    public void ThrowExceptionForInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -15_000,
                    5_000,
                    15
            );
        });
    }

    @Test // Исключение вида IllegalArgumentException для отрицательного лимита
    public void ThrowExceptionForCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    15_000,
                    -5_000,
                    15
            );
        });
    }
    //@Test // Исключение вида IllegalArgumentException для нулевого лимита
    //public void ThrowExceptionForZeroCreditLimit() {
    //    Assertions.assertThrows(IllegalArgumentException.class, () -> {
    //       CreditAccount account = new CreditAccount(
    //            15_000,
    //            0,
    //            15
    //    );
    // });
    // }

    @Test // Исключение вида IllegalArgumentException для отрицательного процента
    public void ThrowExceptionForInitialRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    15_000,
                    5_000,
                    -15
            );
        });
    }

    @Test // Исключение вида IllegalArgumentException для нулевого процента
    public void ThrowExceptionForInitialZeroRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    15_000,
                    5_000,
                    0
            );
        });
    }

    @Test // Расчет процентов при отрицательном балансе
    public void shouldNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test // Расчет процентов при отрицательном балансе c покупкой
    public void shouldNegativeBalanceAndAmount() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        account.pay(400);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test // Расчет процентов при положительном балансе
    public void shouldPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test // Расчет процентов при положительном балансе c покупкой
    public void shouldPositiveBalanceAndAmount() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.pay(400);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test // Расчет процентов при нулевом балансе
    public void shouldZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test // Расчет процентов с нецелочисленным результатом
    public void shouldFractionBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                3
        );
        account.pay(60);
        Assertions.assertEquals(1, account.yearChange());
    }
}



