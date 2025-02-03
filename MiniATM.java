import java.util.*;

public class MiniATM {

    public static void main(String[] args) {
        int pin = 1234;
        float balance = 10000;
        float deposit = 0;
        float withdraw = 0;

        String name;
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your pin: ");
        int password = scn.nextInt();
        int attempt = 0;
        
        // PIN validation with maximum attempts
        while (password != pin && attempt < 3) {
            attempt++;
            if (attempt < 3) {
                System.err.println("Invalid pin. Try again.");
                System.out.print("Enter your pin: ");
                password = scn.nextInt();
            } else {
                System.err.println("Too many incorrect attempts. Exiting.");
                scn.close();
                return;
            }
        }

        // After valid pin
        if (password == pin) {
            System.out.println("Enter your name: ");
            name = scn.next();
            System.out.println("Welcome, " + name);

            // Main ATM menu
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("Press 1 to check Balance");
                System.out.println("Press 2 to deposit");
                System.out.println("Press 3 to withdraw");
                System.out.println("Press 4 to view Receipt");
                System.out.println("Press 5 to exit");
                System.out.print("Enter your choice: ");
                
                int opt;
                try {
                    opt = scn.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number between 1 and 5.");
                    scn.next();  // Clear invalid input
                    continue;
                }

                switch (opt) {
                    case 1:
                        System.out.println("Your current balance is: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        deposit = scn.nextFloat();
                        if (deposit < 0) {
                            System.err.println("Deposit amount cannot be negative.");
                        } else {
                            balance += deposit;
                            System.out.println("Transaction Successful. Deposited: " + deposit);
                        }
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        withdraw = scn.nextFloat();
                        if (withdraw < 0) {
                            System.err.println("Withdrawal amount cannot be negative.");
                        } else if (withdraw > balance) {
                            System.err.println("Insufficient balance. Try a lesser amount.");
                        } else {
                            balance -= withdraw;
                            System.out.println("Withdrawal Successful. Amount withdrawn: " + withdraw);
                        }
                        break;

                    case 4:
                        System.out.println("------ ATM Receipt ------");
                        System.out.println("Name: " + name);
                        System.out.println("Balance: " + balance);
                        System.out.println("Deposit amount this session: " + deposit);
                        System.out.println("Withdrawal amount this session: " + withdraw);
                        System.out.println("Thank you for using our ATM.");
                        break;

                    case 5:
                        System.out.println("Exiting... Thank you for using our ATM.");
                        scn.close();
                        return; // Exit the program

                    default:
                        System.err.println("Invalid option. Please select between 1 and 5.");
                }
            }
        }
    }
}
