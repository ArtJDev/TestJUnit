public class SavingsAccount extends Account {
    int balance;

    SavingsAccount(int balance) {
        this.balance = balance;
    }

    @Override
    boolean checkBalance(int amount) {
        return balance - amount >= 0;
    }

    @Override
    public int addMoney(int amount) {
        balance += amount;
        return balance;
    }

    @Override
    public int transfer(Account account, int amount) {
        if (checkBalance(amount) && account.checkBalance(amount)) {
            account.addMoney(amount);
            balance -= amount;
        } else
            System.out.println("Невозможно выполнить перевод на указанную сумму");
        return balance;
    }

    public String toString() {
        return String.valueOf(balance);
    }
}