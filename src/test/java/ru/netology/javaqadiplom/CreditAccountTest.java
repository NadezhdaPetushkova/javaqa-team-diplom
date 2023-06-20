package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    // Аналогичный тест в блоке тестирования add
    /* @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }*/

    /*@Test // в случае необходимости тест для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceMoreCreditLimit () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    10_000,
                    5_000,
                    15
            );
        });
    }

    @Test // в случае необходимости тест для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceMoreCreditLimitForOne () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_001,
                    5_000,
                    15
            );
        });
    }

    @Test // в случае необходимости тест для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceLessCreditLimit () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    3_000,
                    5_000,
                    15
            );
        });
    }

    @Test // в случае необходимости тест для условия: при создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
    public void exceptionInitialBalanceLessCreditLimitForOne () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    3_000,
                    3_001,
                    15
            );
        });
    }*/

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
    public void RateEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void RateEqualOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                1
        );
        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void RateEqualOneHundred() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                100
        );
        Assertions.assertEquals(100, account.getRate());
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
    public void CreditLimitEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                0,
                15
        );
        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void CreditLimitEqualOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                1,
                15
        );
        Assertions.assertEquals(1, account.getCreditLimit());
    }

    @Test
    public void CreditLimitVeryBig() {
        CreditAccount account = new CreditAccount(
                5_000,
                2_100_000_000,
                15
        );
        Assertions.assertEquals(2_100_000_000, account.getCreditLimit());
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
    public void InitialBalanceEqualNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void InitialBalanceEqualOne() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );
        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void InitialBalanceVeryBig() {
        CreditAccount account = new CreditAccount(
                2_100_000_000,
                5_000,
                15
        );
        Assertions.assertEquals(2_100_000_000, account.getBalance());
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
    public void payLessBalanceForOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(4_999);

        Assertions.assertEquals(1, account.getBalance());
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
    public void payMoreBalanceForOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(5_001);

        Assertions.assertEquals(-1, account.getBalance());
    }

    @Test
    public void payMoreBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(6_500);

        Assertions.assertEquals(-1_500, account.getBalance());
    }

    @Test
    public void payLessCreditLimitForOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(9_999);

        Assertions.assertEquals(-4999, account.getBalance());
    }

    @Test
    public void payEqualCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(10000);

        Assertions.assertEquals(-5000, account.getBalance());
    }


    @Test
    public void payMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(20000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void payAmountLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(-1_000));
    }

    @Test
    public void payAmountEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(0));
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
    public void addOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(1);

        Assertions.assertEquals(5_001, account.getBalance());
    }

    @Test
    public void addEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void addMinusOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(-1);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void addLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void addAmountFalseLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(-1_000));
    }

    @Test
    public void addAmountFalseEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(0));
    }

    @Test
    public void yearChangeBalanceMoreNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(500);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeBalanceEqualOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(4_999);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeBalanceEqualNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(5_000);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeBalanceEqualMinusOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(5_001);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeMinusOneRuble() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(5_007);
        Assertions.assertEquals(-1, account.yearChange());
    }

    @Test

    public void yearChangeBalanceLessNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(9_000);
        Assertions.assertEquals(-600, account.yearChange());
    }

    @Test
    public void yearChangeRoundingDecimalLessFive() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                7
        );

        account.pay(9_029);
        Assertions.assertEquals(-282, account.yearChange());
    }

    @Test
    public void yearChangeRoundingDecimalMoreFive() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                7
        );

        account.pay(9_028);
        Assertions.assertEquals(-281, account.yearChange());
    }

    // проверка возможного деления на ноль, если процент может быть нулем
    @Test
    public void yearChangeRateNull() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                0
        );

        account.pay(9_000);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void doubleAdd() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(3_000);
        account.add(4_000);

        Assertions.assertEquals(12_000, account.getBalance());
    }

    @Test
    public void doublePay() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(1_000);
        account.pay(6_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void doubleAddPay() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(7_000);
        account.pay(3_000);

        Assertions.assertEquals(9_000, account.getBalance());
    }

    @Test
    public void doublePayAdd() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(500);
        account.add(7_000);

        Assertions.assertEquals(11_500, account.getBalance());
    }

}