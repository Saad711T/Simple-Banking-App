package bank;

import java.util.Scanner; //Scanner library for inputs

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankManager manager = new BankManager();

        manager.addAccount(new BankAccount(0, "Saad Almalki", 5000.0));
        manager.addAccount(new BankAccount(1, "Thewisdomelder", 3000.0));
        manager.addAccount(new BankAccount(2, "Blockel", 20000.0));


        boolean active = true;
        while (active) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Transfer Money");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter from account number: ");
                    String fromAccount = scanner.nextLine();
                    System.out.print("Enter to account number: ");
                    String toAccount = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();

                    manager.transfer(fromAccount, toAccount, amount);
                    break;
                case 2:
                    System.out.println("Exiting application...");
                    active = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }
}