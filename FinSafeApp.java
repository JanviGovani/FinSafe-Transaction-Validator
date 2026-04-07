import java.util.Scanner;

public class FinSafeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to FinSafe Digital Wallet");

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Initial Deposit: $");
        double initialBalance = scanner.nextDouble();
        
        Account myAccount = new Account(name, initialBalance);
        
        System.out.println("\nAccount Created Successfully!");
        System.out.println("Account Holder: " + myAccount.getAccountHolder());

        while (true) {
            System.out.println("\n[ Current Balance: $" + myAccount.getBalance() + " ]");

            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money (Spend)");
            System.out.println("3. View Mini Statement");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depAmt = scanner.nextDouble();
                    myAccount.deposit(depAmt);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double drawAmt = scanner.nextDouble();
                    try {
                        myAccount.processTransaction(drawAmt);
                    } 
                    catch (InSufficientFundsException e) {
                        System.err.println("ERROR: " + e.getMessage());
                    } 
                    catch (IllegalArgumentException e) {
                        System.err.println("INVALID INPUT: " + e.getMessage());
                    }
                    break;

                case 3:
                    myAccount.printMiniStatement();
                    break;

                case 4:
                    System.out.println("Thank you for using FinSafe. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}