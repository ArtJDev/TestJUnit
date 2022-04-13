public class CreditAccount extends Account {
    int balance;

    CreditAccount(int balance) {
        this.balance = balance;
    }

    @Override
    boolean checkBalance(int amount) {
        return balance + amount <= 0;
    }

    @Override
    public int pay(int amount) {
        return balance -= amount;
    }

    @Override
    public int addMoney(int amount) {
        if (checkBalance(amount)) {
            balance += amount;
        } else System.out.println("Невозможно пополнить кредитный счет на указанную сумму");
        return balance;
    }

    public String toString() {
        return String.valueOf(balance);
    }
}
