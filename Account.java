import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountHolder;
    private double balance;
    
    private List<Double> transactionHistory = new ArrayList<>();

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void processTransaction(double amount) throws InSufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }

        if (amount > balance) {
            throw new InSufficientFundsException("Insufficient Funds! Available: $" + balance);
        }

        balance -= amount;
        
        transactionHistory.add(amount);
        
        if (transactionHistory.size() > 5) {
            transactionHistory.remove(0);
        }

        System.out.println("Withdrew: $" + amount);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void printMiniStatement() {
        System.out.println("\n Mini Statement for " + accountHolder);
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } 
        else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.println((i + 1) + ". Withdrawal: -$" + transactionHistory.get(i));
            }
        }
        System.out.println("Current Balance: $" + getBalance());
    }

    public double getBalance() { 
        return balance; 
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}