package main.java;

public class BankAccount implements Accountable {
    private int balance;

    // Constructor to initialize the balance (defaults to zero if not specified)
    public BankAccount() {
        this.balance = 0;
    }

    // Constructor with an initial balance
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Get the current balance
    @Override
    public int getBalance() {
        return balance;
    }

    // Update the balance and return the new balance
    @Override
    public int updateBalance(int amount) {
        this.balance += amount;
        return balance;
    }

    // Compare this account's balance with another
    @Override
    public int compareTo(Accountable other) {
        return Integer.compare(this.balance, other.getBalance());
    }
}

