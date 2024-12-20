import java.util.*;

public class MiniATM{

    public static void main(String[] args) {
        // System.out.println(args);
        int pin = 1234;
        float Balance = 10000;
        float deposit = 0;
        float withdraw = 0;

        String Name;

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your pin");

        int password = scn.nextInt();
       // System.err.println(password);
       int attempt =0;
       {
        if(password == pin)
        {
            System.out.println("Enter your name");
            Name =scn.next();
            System.out.println("Wellcome"+Name);

            while(true)
            {
                System.out.println("Press 1 to check Balance");
                System.out.println("Press 2 to deposit");
                System.out.println("Press 3 to withdraw");
                System.out.println("Press 4 to Recepit");
                System.out.println("press 5 to exit");

                int opt=scn.nextInt();
                switch (opt)
                {
                    case 1:
                        System.out.println("Your current balance is"+Balance );
                        break;
                    case 2:
                        System.out.println("How much Amount you going to ADD");
                        deposit =scn.nextInt();
                        System.out.println("Transaction Successful");
                        Balance=deposit+Balance;
                        break;
                    case 3:
                        System.out.println("How much Amount you going to withdraw");
                        withdraw = scn.nextInt();
                        if(withdraw >= Balance)
                        {
                            System.out.println("Insufficent Balance");
                            System.out.println("Try less-than your Balance");
                        }
                        else
                        {
                            System.out.print("Withdraw Succesfull");
                            Balance = Balance - withdraw;
                        }
                        break;
                    case 4:
                            System.out.println("Wellcome to ATM");
                            System.out.println("Balance"+Balance);
                            System.out.print("deposit amount"+deposit);
                            System.out.println("withdraw amount"+withdraw);
                            System.out.print("Thanks for comming");
                            break;
                    case 5:
                            System.out.println("press 5 to exit");
                            break;


                }

            }
        }
        else
        {
            System.err.println("Invalid pin");
        }
    }

    }
}