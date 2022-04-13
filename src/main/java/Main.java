public class Main {
    public static void main(String[] args) {
        Account checkingAccount1 = new CheckingAccount(50_000);
        Account savingAccount = new SavingsAccount(30_000);
        Account creditAccount = new CreditAccount(-10_000);

        System.out.println("Баланс расчетного счета = " + checkingAccount1);
        System.out.println("Баланс сберегательного счета = " + savingAccount);
        System.out.println("Баланс кредитного счета = " + creditAccount + "\n");

        System.out.println("С расчетного счета заплатили 5000");
        System.out.println("Баланс расчетного счета = " + checkingAccount1.pay(5_000));
        System.out.println("Расчетный счет пополнили на 10000");
        System.out.println("Баланс расчетного счета = " + checkingAccount1.addMoney(10_000));
        System.out.println("Перевод 3000 со сберегательного счета на расчетный счет");
        savingAccount.transfer(checkingAccount1, 3_000);
        System.out.println("Баланс расчетного счета = " + checkingAccount1);
        System.out.println("Баланс сберегательного счета = " + savingAccount);
        System.out.println("Кредитный счет пополнили на 7000");
        System.out.println("Баланс кредитного счета = " + creditAccount.addMoney(7_000));
        System.out.println("С кредитного счета заплатили 8000");
        creditAccount.pay(8_000);
        System.out.println("Баланс кредитного счета = " + creditAccount);
        System.out.println("С расчетного счета перевели 5000 на кредитный сет");
        checkingAccount1.transfer(creditAccount, 5_000);
        System.out.println("Баланс расчетного счета = " + checkingAccount1);
        System.out.println("Баланс кредитного счета = " + creditAccount);
        System.out.println("Со сберегательного счета перевели 7000 на кредитный счет");
        savingAccount.transfer(creditAccount, 7_000);
        System.out.println("Баланс сберегательного счета = " + savingAccount);
        System.out.println("Баланс кредитного счета = " + creditAccount);
    }
}