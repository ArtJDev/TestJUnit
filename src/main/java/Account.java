public abstract class Account{
    abstract boolean checkBalance(int amount);

    abstract int addMoney(int amount);

    public int pay(int amount) {
        return 0;
    }

    public int transfer(Account account, int amount) {
        return 0;
    }
}