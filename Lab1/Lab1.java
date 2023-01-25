
// package 22122140-MDS273L-JAVA.Lab1;
import java.util.*;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Enter your details:");
        System.out.println("==========================================");
        System.out.print("Enter your First Name: ");
        String fname = scan.nextLine();
        System.out.print("Enter your Last Name: ");
        String lname = scan.nextLine();
        System.out.print("Enter your Gender (M|F): ");
        char gender = Character.toUpperCase(scan.nextLine().charAt(0));
        System.out.print("Enter your Age: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.print("Enter your State: ");
        String state = scan.nextLine().toLowerCase();
        System.out.println("==========================================");
        System.out.println("==========================================");
        System.out.println("Your Details are listed below:");
        System.out.println("==========================================");
        System.out.println("Full Name: " + fname + " " + lname);
        if (gender == 'M') {
            System.out.println("Gender: Male");
        } else if (gender == 'F') {
            System.out.println("Gender: Female");
        }
        System.out.println("Age: " + age);
        switch (state) {
            case "andhra pradesh":
            case "karnataka":
            case "kerala":
            case "tamil nadu":
            case "telangana":
                System.out.println("State name: " + state + "\nState Region: South");
                break;
            case "jammu & kashmir":
            case "himachal pradesh":
            case "punjab":
            case "uttarakhand":
            case "haryana":
            case "delhi":
            case "rajasthan":
            case "uttar pradesh":
            case "chandigarh":
                System.out.println("State name: " + state + "\nState Region: North");
                break;
            case "arunachal pradesh":
            case "assam":
            case "manipur":
            case "meghalaya":
            case "mizoram":
            case "nagaland":
            case "sikkim":
            case "tripura":
                System.out.println("State name: " + state + "\nState Region: East");
                break;
            case "goa":
            case "gujarat":
            case "maharashtra":
                System.out.println("State name: " + state + "\nState Region: West");
                break;
            case "madhya pradesh":
                System.out.println("State name: " + state + "\nState Region: Central");
                break;
            default:
                System.out.println("State name: " + state + "\nState Region: Cannot Recognize Region");
        }
        System.out.println("==========================================");
        scan.close();
    }
}