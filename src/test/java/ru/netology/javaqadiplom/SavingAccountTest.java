package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddZeroToInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddOneToInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(1);

        Assertions.assertEquals(2_001, account.getBalance());
    }

    @Test
    public void shouldAddMinusOneToInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeToInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddToInitialBalanceButMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddToInitialBalanceEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void shouldAddToInitialBalanceLessMaxBalanceMinusOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_999);

        Assertions.assertEquals(9_999, account.getBalance());
    }

    @Test
    public void shouldAddToInitialBalanceMoreMaxBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void TestIfInitialBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void TestIfInitialBalanceEqualOne() {
        SavingAccount account = new SavingAccount(
                1,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void TestIfInitialBalanceVeryBig() {
        SavingAccount account = new SavingAccount(
                2_000_000_000,
                0,
                2_100_000_000,
                5
        );

        Assertions.assertEquals(2_000_000_000, account.getBalance());
    }


    @Test
    public void TestIfMinBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void TestIfMinBalanceEqualOne() {
        SavingAccount account = new SavingAccount(
                1,
                1,
                10_000,
                5
        );

        Assertions.assertEquals(1, account.getMinBalance());
    }

    @Test
    public void TestIfMinBalanceVeryBig() {
        SavingAccount account = new SavingAccount(
                2_000_000_000,
                2_000_000_000,
                2_100_000_000,
                5
        );

        Assertions.assertEquals(2_000_000_000, account.getMinBalance());
    }

    @Test
    public void TestIfMaxBalanceEqualOne() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                1,
                5
        );

        Assertions.assertEquals(1, account.getMaxBalance());
    }

    @Test
    public void TestIfMaxBalanceVeryBig() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                2_100_000_000,
                5
        );

        Assertions.assertEquals(2_100_000_000, account.getMaxBalance());
    }

    @Test
    public void TestIfRateEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void TestIfRateEqualOne() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void TestIfRateEqualOneHundred() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                100
        );

        Assertions.assertEquals(100, account.getRate());
    }
    @Test
    public void maxBalanceEqualNullNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    0,
                    0,
                    0,
                    5
            );
        });
    }

    @Test
    public void initialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -2_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialBalanceNegativeMinusOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -1,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void minBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void minBalanceNegativeMinusOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceNegativeMinusOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -1,
                    5
            );
        });
    }

    @Test
    public void rateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void rateNegativeMinusOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    public void initialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    200,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    100,
                    5
            );
        });
    }


    @Test
    public void initialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    20_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void successfulPay() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);
     //   boolean result = account.pay(500);

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void successfulPayOne() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);
        //   boolean result = account.pay(500);

        account.pay(1);

        Assertions.assertEquals(1_999, account.getBalance());
    }

    @Test
    public void payZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        //boolean result = account.pay(0);

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payNegative() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        //boolean result = account.pay(-1_000);

        account.pay(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payNegativeMinusOne() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        //boolean result = account.pay(-1_000);

        account.pay(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payIfAmountMoreBalance() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);

        boolean result = account.pay(2_500);

        account.pay(2_500);

        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void payIfAmountMoreBalanceOne() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);

        boolean result = account.pay(2001);

        account.pay(2001);

        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void balanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        boolean result = account.pay(1_000);

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    @Test
    public void balanceLessMinBalanceOne() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        boolean result = account.pay(1_001);

        account.pay(1_001);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void interestOnTheBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        int result = account.yearChange();

        Assertions.assertEquals(100, result);
    }

    @Test
    public void yearChangeRateZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        int result = account.yearChange();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void yearChangeBalanceZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                10
        );

        int result = account.yearChange();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void yearChangeRoundingDecimalLessFive() {
        SavingAccount account = new SavingAccount(
                2_134,
                1_000,
                10_000,
                3
        );

        int result = account.yearChange();

        Assertions.assertEquals(64, result);
    }

    @Test
    public void yearChangeRoundingDecimalMoreFive() {
        SavingAccount account = new SavingAccount(
                2_133,
                1_000,
                10_000,
                3
        );

        int result = account.yearChange();

        Assertions.assertEquals(63, result);
    }

    @Test
    public void doubleAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);
        account.add(4_000);

        Assertions.assertEquals(9_000, account.getBalance());
    }

    @Test
    public void doublePay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(100);
        account.pay(200);

        Assertions.assertEquals(1_700, account.getBalance());
    }

    @Test
    public void doubleAddPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_000);
        account.pay(1_000);

        Assertions.assertEquals(8_000, account.getBalance());
    }

    @Test
    public void doublePayAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);
        account.add(7_000);

        Assertions.assertEquals(8_500, account.getBalance());
    }
}