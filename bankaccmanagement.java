import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private static int counter = 1000;
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String name) {
        this.accountNumber = ++counter;
        this.accountHolderName = name;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber + ", Name: " + accountHolderName + ", Balance: " + balance);
    }
}

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(String name) {
        Account account = new Account(name);
        accounts.add(account);
        System.out.println("Account created with account number: " + account.getAccountNumber());
    }

    public Account searchAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;  // Account not found
    }

    public void displayAllAccounts() {
        for (Account acc : accounts) {
            acc.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display Accounts\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    bank.createAccount(name);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accNumber = scanner.nextInt();
                    Account account = bank.searchAccount(accNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    account = bank.searchAccount(accNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    bank.displayAllAccounts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
