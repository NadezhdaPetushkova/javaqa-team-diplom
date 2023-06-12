package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void exceptionRateBelowNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    5_000,
                    -1
            );
        });
    }

    @Test
    public void exceptionRateEqualNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    5_000,
                    0
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException для кредитного лимита (creditLimit - неотрицательное число)
    public void exceptionCreditLimitBelowNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -1,
                    15
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException для кредитного лимита (creditLimit - неотрицательное число) и соответсвенно не ноль
    public void exceptionCreditLimitNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    0,
                    15
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException начального баланса (initialBalance - неотрицательное число)
    public void exceptionInitialBalanceBelowNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1,
                    5_000,
                    15
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException начального баланса (initialBalance - неотрицательное число) и соответсвенно не ноль
    public void exceptionInitialBalanceNull () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    15
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceMoreCreditLimit () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    10_000,
                    5_000,
                    15
            );
        });
    }

    @Test // Не реализовано исключение вида IllegalArgumentException для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceLessCreditLimit () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    3_000,
                    5_000,
                    15
            );
        });
    }

    @Test // некорректный расчет: актуальное значение получается -3000
    public void payLessBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // некорректный расчет: актуальное значение получается -6000
    public void payMoreBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test // некорректный расчет: актуальное значение получается -5000
    public void payEqualBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void payMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(11_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void amountLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void amountEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test // некорректный расчет: актуальное значение получается 3000
    public void addMoreNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(8000, account.getBalance());
    }

    @Test
    public void addLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test //некорректный расчет процент должен браться на сумму, которая не изменяется в течение года, а не на текущий баланс.
    // Не хватает переменной для неснижаемого остатка.
    public void yearChangeNonDeductibleAccountBalanceMoreNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        // нет ожидания, пока нет поля для неснижаемого остатка в течение года
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test //некорректный расчет процент должен браться на сумму, которая не изменяется в течение года, а не на текущий баланс.
    // Не хватает переменной для неснижаемого остатка.
    public void yearChangeNonDeductibleAccountBalanceEquallyNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        // нет ожидания, пока нет поля для неснижаемого остатка в течение года
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test //некорректный расчет процент должен браться на сумму, которая не изменяется в течение года, а не на текущий баланс.
    // Не хватает переменной для неснижаемого остатка.
    public void yearChangeNonDeductibleAccountBalanceLessNull() {
        CreditAccount account = new CreditAccount(
                -3_000,
                5_000,
                15
        );

        // нет ожидания, пока нет поля для неснижаемого остатка в течение года
        Assertions.assertEquals(0, account.yearChange());
    }

}
