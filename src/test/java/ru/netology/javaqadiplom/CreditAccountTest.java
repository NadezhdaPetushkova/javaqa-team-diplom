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

    @Test
    public void exceptionRateBelowNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    5_000,
                    -1
            );
        });
    }

    @Test
    public void exceptionRateEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void exceptionCreditLimitBelowNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -1,
                    15
            );
        });
    }

    @Test
    public void exceptionCreditLimitNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                0,
                15
        );
        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void exceptionInitialBalanceBelowNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void exceptionInitialBalanceNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void payLessBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payMoreBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
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

    @Test
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

    @Test
    public void yearChangeNonDeductibleAccountBalanceMoreNull() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(500);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeNonDeductibleAccountBalanceEquallyNull() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(1_000);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test

    public void yearChangeNonDeductibleAccountBalanceLessNull() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(4_000);
        Assertions.assertEquals(-450, account.yearChange());
    }
}