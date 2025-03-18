package bank;

import java.util.HashMap;
import java.util.Map;

public class BankManager {
    private Map<String, BankAccount> accounts;

    public BankManager() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = accounts.get(fromAccountNumber);
        BankAccount toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
            return false;
        }

        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
            return true;
        } else {
            System.out.println("Insufficient funds for transfer.");
            return false;
        }
    }
}
