import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Lab7 {
    // This function will take an array as an argument and it will return the same
    // array after sorting in ascending order.
    static float[] sortArray(float[] arr) {
        float temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // This function will calculate and return the mean of the array which is passed
    // in argument.
    static float calMean(float[] arr) {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    // This function will calculate and return the median value of the array which
    // is passed in argument.
    static float calMedian(float[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    // This function will calculate and return the mode of the array which is passed
    // in argument.
    static float calMode(float[] arr) {
        float mode = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }
        return mode;
    }

    // This function will calculate and return the minimum value of the array which
    // is passed in argument.
    static float findMin(float[] arr) {
        return arr[0];
    }

    // This function will calculate and return the maximum value of the array which
    // is passed in argument.
    static float findMax(float[] arr) {
        return arr[arr.length - 1];
    }

    // This function will take file as an argument and it will print all the summary
    // statistics in proper format.
    static String calOverAllStats(File myFile) throws FileNotFoundException {
        String printContent = "";
        Scanner scan = new Scanner(myFile);
        // Skipping the first row of the file as it contains the header part.
        scan.nextLine();
        // Counting the number of lines the file contains.
        int countLines = 0;
        while (scan.hasNextLine()) {
            // Just reading the
            scan.nextLine();
            countLines += 1;
        }
        // Creating arrays of exact values.
        float[] sepalLength = new float[countLines];
        float[] sepalWidth = new float[countLines];
        float[] petalLength = new float[countLines];
        float[] petalWidth = new float[countLines];
        int i = 0;
        scan.close();
        // Again reading the file from starting.
        scan = new Scanner(myFile);
        // Skipping the first row of the file as it contains the header part.
        scan.nextLine();
        // Iterating through each row.
        while (scan.hasNextLine()) {
            String[] s;
            String line = scan.nextLine();
            // Splitting each row based on commas and assigning each value of respected
            // column to its respected array.
            s = line.split(",");
            sepalLength[i] = Float.parseFloat(s[1]);
            sepalWidth[i] = Float.parseFloat(s[2]);
            petalLength[i] = Float.parseFloat(s[3]);
            petalWidth[i] = Float.parseFloat(s[4]);
            i++;
        }

        // Sorting all the values of the arrays in ascending order.
        sepalLength = sortArray(sepalLength);
        sepalWidth = sortArray(sepalWidth);
        petalLength = sortArray(petalLength);
        petalWidth = sortArray(petalWidth);

        // Storing all the details in good format and returning the content as a string.

        printContent += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", " ", "Mean", "Median", "Mode", "Minimum",
                "Maximum");
        printContent += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Sepal Length", calMean(sepalLength),
                calMedian(sepalLength), calMode(sepalLength), findMin(sepalLength), findMax(sepalLength));
        printContent += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Sepal Width", calMean(sepalWidth),
                calMedian(sepalWidth), calMode(sepalWidth), findMin(sepalWidth), findMax(sepalWidth));
        printContent += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Petal Length", calMean(petalLength),
                calMedian(petalLength), calMode(petalLength), findMin(petalLength), findMax(petalLength));
        printContent += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Petal Width", calMean(petalWidth),
                calMedian(petalWidth), calMode(petalWidth), findMin(petalWidth), findMax(petalWidth));

        // Closing the scanner object.
        scan.close();
        return printContent;
    }

    public static void main(String[] args) {
        // Creating string objects to store the content of each file.
        String irisSetosa = "";
        String irisVersicolor = "";
        String irisVerginica = "";
        String fileContent = "";
        try {
            // Opening the file.
            File myFile = new File("Iris.csv");
            Scanner scan = new Scanner(myFile);
            // Readingband storing the first row of the file.
            String firstRow = scan.nextLine();
            irisSetosa = firstRow + "\n";
            irisVersicolor = firstRow + "\n";
            irisVerginica = firstRow + "\n";

            // Iterating through the file.
            while (scan.hasNextLine()) {
                String[] s;
                String line = scan.nextLine();
                s = line.split(",");
                // Storing the rows of differnt species in their respective string objects.
                if (s[5].equalsIgnoreCase("Iris-setosa")) {
                    irisSetosa += line + "\n";
                } else if (s[5].equalsIgnoreCase("Iris-versicolor")) {
                    irisVersicolor += line + "\n";
                } else {
                    irisVerginica += line + "\n";
                }
            }

            // Creating separate files for each of the different species, so that we can
            // pass these files directly to our calOverAllStats() function.
            FileWriter irisSetosaFile = new FileWriter("irisSetosa.csv");
            irisSetosaFile.write(irisSetosa);
            irisSetosaFile.close();

            FileWriter irisVersicolorFile = new FileWriter("irisVersicolor.csv");
            irisVersicolorFile.write(irisVersicolor);
            irisVersicolorFile.close();

            FileWriter irisVerginicaFile = new FileWriter("irisVerginica.csv");
            irisVerginicaFile.write(irisVerginica);
            irisVerginicaFile.close();

            // Storing the output in a decorated format.
            fileContent += "=======================================================================================\n====================================OVERALL SUMMARY====================================\n=======================================================================================\n";
            fileContent += calOverAllStats(myFile);
            fileContent+="=======================================================================================\n======================================IRIS SETOSA======================================\n=======================================================================================\n";
            File irisSetosaCsvFile = new File("irisSetosa.csv");
            fileContent += calOverAllStats(irisSetosaCsvFile);
            fileContent+="=======================================================================================\n====================================IRIS VERSICOLOR====================================\n=======================================================================================\n";
            File irisVersicolorCsvFile = new File("irisVersicolor.csv");
            fileContent += calOverAllStats(irisVersicolorCsvFile);
            fileContent+="=======================================================================================\n=====================================IRIS VERGINICA====================================\n=======================================================================================\n";
            File irisVerginicaCsvFile = new File("irisVerginica.csv");
            fileContent += calOverAllStats(irisVerginicaCsvFile);
            fileContent+="=======================================================================================";

            // Printing the final output.
            System.out.println(fileContent);

            // Creating and writing the final output in a txt file.
            FileWriter outputContent=new FileWriter("Output.txt");
            outputContent.write(fileContent);
            outputContent.close();

            // Closing the scanner object.
            scan.close();
        } catch (Exception e) {
            System.out.println("An Error Occured!" + e.getMessage());
        }
    }
}
