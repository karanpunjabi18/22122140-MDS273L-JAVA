
// Importing the necessary classes. Scanner class for reading the inputs, Date class to create an date object, Timestamp class to get the timestamp of the transactions.
import java.util.Scanner;
import java.util.Date;
import java.sql.Timestamp;

public class Lab4 {
    // Declaring all the necessary global variables.
    static Scanner scan = new Scanner(System.in);
    static String accNo;
    static String holderName;
    static double balance = 0.0;

    // This function will be called only once in the programme at the beginning.
    static void initCustomer() {
        System.out.println("=================================================================================");
        System.out.print("Enter the Name of the Customer:");
        holderName = scan.nextLine();
        System.out.print("Enter the Account Number of the Customer:");
        accNo = scan.nextLine();
        balance = 0.0;
        System.out.println("=================================================================================");
    }

    // This function will add the deposited amount to the balance and it will return
    // a String with all the transaction details.
    static String deposit() {
        System.out.println("=================================================================================");
        System.out.print("Enter the amount you want to deposit:");
        // Type casting the input string to double value.
        double deposit = Double.parseDouble(scan.nextLine());
        System.out.println("=================================================================================");
        Date date = new Date();
        // date.getTime() will give you the current timestamp.
        Timestamp ts = new Timestamp(date.getTime());
        String str = "";
        if (deposit > 0.0) {
            // Updating our string variable so that we can return the transaction details.
            str += "DateTime:" + ts.toString() + " ";
            str += "Previous Balance:" + balance + " ";
            balance += deposit;
            str += "Updated Balance: " + balance + " ";
            str += "Type: Deposit ";
            str += "Amount: " + deposit + " ";
            str += "Status: Success";
            System.out.println("=================================================================================");
            System.out.println("Deposit Successfull");
            System.out.println("Updated Balance: " + balance);
            System.out.println("=================================================================================");
            return str;
        } else {
            System.out.println("=================================================================================");
            System.out.println("Error! Please enter a valid amount.");
            System.out.println("=================================================================================");
            return "";
        }
    }

    // This function will deduct the withdrawn amount from the balance and it will
    // return a String with all the transaction details.
    static String withdraw() {
        System.out.println("=================================================================================");
        System.out.print("Enter the amount you want to withdraw:");
        // Type casting the input string to double value.
        double withdraw = Double.parseDouble(scan.nextLine());
        System.out.println("=================================================================================");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        String str = "";
        if (withdraw <= balance) {
            // Updating our string variable so that we can return the transaction details.
            str += "DateTime:" + ts.toString() + " ";
            str += "Previous Balance:" + balance + " ";
            balance -= withdraw;
            str += "Updated Balance:" + balance + " ";
            str += "Type: Withdraw ";
            str += "Amount: " + withdraw + " ";
            str += "Status: Success";
            System.out.println("=================================================================================");
            System.out.println("Withdraw Successfull");
            System.out.println("Updated Balance: " + balance);
            System.out.println("=================================================================================");
            return str;
        } else {
            System.out.println("=================================================================================");
            System.out.println("Error! Insufficient Balance.");
            System.out.println("=================================================================================");
            return "";
        }
    }
    // This function will only print all the valid transaction details of the account and it won't return anything
    static void printTransactions(String[] transactions) {
        System.out.println("=================================================================================");
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[0] == null) {
                System.out.println("=================================================================================");
                System.out.println("No Transactions to print.");
                System.out.println("=================================================================================");
                break;
            } else if (transactions[i] == null) {
                break;
            } else if (transactions[i].equalsIgnoreCase("")) {
                continue;
            } else {
                System.out.println(transactions[i]);
            }
        }
        System.out.println("=================================================================================");
    }

    static void printSummary() {
        System.out.println("=================================================================================");
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Account Number: " + accNo);
        System.out.println("Total Balance: " + balance);
        System.out.println("=================================================================================");
    }

    public static void main(String[] args) {
        String[] transactions = new String[1024];
        initCustomer();
        int choice = 0;
        int i = 0;
        do {
            System.out.println("=================================================================================");
            System.out.println("1) Deposit Money.");
            System.out.println("2) Withdraw Money.");
            System.out.println("3) Print Transactions.");
            System.out.println("4) Print Account Summary.");
            System.out.println("5) Exit.");
            System.out.println("=================================================================================");
            System.out.print("Please Enter your choice:");
            choice = Integer.parseInt(scan.nextLine());
            System.out.println("=================================================================================");
            switch (choice) {
                case 1:
                    transactions[i] = deposit();
                    i += 1;
                    break;
                case 2:
                    transactions[i] = withdraw();
                    i += 1;
                    break;
                case 3:
                    printTransactions(transactions);
                    break;
                case 4:
                    printSummary();
                    break;
                case 5:
                    break;
                default:
                    System.out.println(
                            "=================================================================================");
                    System.out.println("Please enter a valid choice.");
                    System.out.println(
                            "=================================================================================");
                    break;
            }
        } while (choice != 5);
    }
}
