package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            //hello
        // Read the number of elements
        int n = scanner.nextInt();
        BankAccount[] accounts = new BankAccount[n];

        // Read the balances and create BankAccount objects
        for (int i = 0; i < n; i++) {
            int balance = scanner.nextInt();
            accounts[i] = new BankAccount(balance);
        }

        //fjrifjrjf

        // Compute sum, product, min, and max using balances
        int sum = computeSum(accounts);
        long product = computeProduct(accounts);
        int min = computeMin(accounts);
        int max = computeMax(accounts);

        // Print the results
        System.out.printf("%d %d %d %d\n", sum, product, min, max);
    }

    // Compute the sum of the balances
    private static int computeSum(BankAccount[] accounts) {
        int sum = 0;
        for (BankAccount account : accounts) {
            sum += account.getBalance();
        }
        return sum;
    }

    // Compute the product of the balances
    private static long computeProduct(BankAccount[] accounts) {
        long product = 1;
        for (BankAccount account : accounts) {
            product *= account.getBalance();
        }
        return product;
    }

    // Find the minimum balance
    private static int computeMin(BankAccount[] accounts) {
        int min = accounts[0].getBalance();
        for (BankAccount account : accounts) {
            if (account.getBalance() < min) {
                min = account.getBalance();
            }
        }
        return min;
    }

    // Find the maximum balance
    private static int computeMax(BankAccount[] accounts) {
        int max = accounts[0].getBalance();
        for (BankAccount account : accounts) {
            if (account.getBalance() > max) {
                max = account.getBalance();
            }
        }
        return max;
    }
}

