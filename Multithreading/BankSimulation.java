package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal: " + amount);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}


class Customer implements Runnable {
    private BankAccount account;

    public Customer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            double amount = Math.random() * 100;
            if (Math.random() < 0.5) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            try {
                // Introduce a short delay for demonstration purposes
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000);
        int numberOfCustomers = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCustomers);

        for (int i = 0; i < numberOfCustomers; i++) {
            executorService.execute(new Customer(sharedAccount));
        }

        executorService.shutdown();

        try {
            // Wait for all threads to complete
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + sharedAccount.getBalance());
    }
}
