import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance; // Holds the account balance

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for the withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input
    public void start() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    // Method to handle checking balance
    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.checkBalance());
    }

    // Method to handle deposit
    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to handle withdrawal
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main class to run the ATM system
public class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(500.00); // Initial balance is $500

        // Create an ATM object with the bank account
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.start();
    }
}