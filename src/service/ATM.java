package service;

import model.Transaction;
import model.User;

public class ATM {
	private User user;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;

    public ATM(User user) {
        this.user = user;
        this.balance = 0;
        this.transactions = new Transaction[100];
        this.transactionCount = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Transaction("Deposit", amount);
        System.out.println("Deposited: INR " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions[transactionCount++] = new Transaction("Withdraw", amount);
            System.out.println("Withdrawn: INR " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(double amount, String recipient) {
        if (balance >= amount) {
            balance -= amount;
            transactions[transactionCount++] = new Transaction("Transfer to " + recipient, amount);
            System.out.println("Transferred INR " + amount + " to " + recipient);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            Transaction transaction = transactions[i];
            System.out.println(transaction.getType() + ": INR " + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }
}
