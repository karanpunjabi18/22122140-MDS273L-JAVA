
// importing the java.util.Scanner package to use Scanner class
import java.util.Scanner;

public class Lab3 {
    static int n = 0;

    // Creating a static function to find mean of the array.
    static float findMean(float[] arr) {
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum / n;
    }

    // Creating a static function to find median of the array.
    static float findMedian(float[] arr) {
        // Sorting the array in ascending order.
        for (int i = 0; i < n; i++) {
            float temp = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // location variable
        int loc = 0;
        // if there are even number of observations
        if (n % 2 == 0) {
            loc = n / 2;
            return (arr[loc - 1] + arr[loc]) / 2;
        }
        // if there are odd number of observations
        else {
            loc = n / 2;
            return arr[loc];
        }
    }

    // Creating a static function to find mode of the array.
    static float findMode(float[] arr) {
        // maxVal will store our mode.
        float maxVal = 0;
        // maxCount will store the maximum count of each element.
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        System.out.println("=============================================");
        System.out.println("-----------------WELCOME!--------------------");
        System.out.println("=============================================");
        float[] arr = new float[1024];
        // Displaying Menu.
        do {
            System.out.println("=============================================");
            System.out.println("Please choose from the following:");
            System.out.println("1) Enter the values:");
            System.out.println("2) Find Mean:");
            System.out.println("3) Find Median");
            System.out.println("4) Find Mode");
            System.out.println("5) Exit:");
            System.out.println("=============================================");
            System.out.print("Please enter your choice:");
            // Reading the choice of the user.
            choice = Integer.parseInt(scan.nextLine());
            System.out.println("=============================================");
            switch (choice) {
                case 1:
                    arr = new float[1024];
                    System.out.print("How many values you want to enter?:");
                    // Reading the value of n.
                    n = Integer.parseInt(scan.nextLine());
                    // Reading and Storing the values of array.
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter value " + (i + 1) + ":");
                        arr[i] = Float.parseFloat(scan.nextLine());
                    }
                    break;
                case 2:
                    // Calling findMean function to calculate the mean of the values.
                    float mean = findMean(arr);
                    System.out.println("=============================================");
                    System.out.println("Mean of the values is " + mean);
                    System.out.println("=============================================");
                    break;
                case 3:
                    // Calling findMedian function to calculate the mean of the values.
                    float median = findMedian(arr);
                    System.out.println("=============================================");
                    System.out.println("Median of the values is " + median);
                    System.out.println("=============================================");
                    break;
                case 4:
                    // Calling findMode function to calculate the mean of the values.
                    float mode = findMode(arr);
                    System.out.println("=============================================");
                    System.out.println("Mode of the values is " + mode);
                    System.out.println("=============================================");
                    break;
                case 5:
                    System.out.println("=============================================");
                    System.out.println("----------------Thank You!-------------------");
                    System.out.println("=============================================");
                    break;
                default:
                    // For any other choices other than 1,2,3,4,5
                    System.out.println("=============================================");
                    System.out.println("Please enter a valid choice!!:");
                    System.out.println("=============================================");
                    break;
            }
        } while (choice != 5);
        // Closing the scanner object
        scan.close();
    }
}
