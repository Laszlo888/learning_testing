public class BankAccount {
    Integer balance;

    public BankAccount() {
        balance = 1000;
    }

    void deposit(int amount) {
        balance = balance + amount;
    }

    void withdraw(int amount) {
        balance = balance - amount;
    }
}
