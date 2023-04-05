// Importing all the necessary packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab6 {
    // This function will count the vowels present in the entire string and return an array like [2,3,1,6,2] representing values counts for each vowel respectively.
    static int[] vowelCount(String s) {
        int[] vowelCount = { 0, 0, 0, 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                case 'a':
                    vowelCount[0] += 1;
                    break;
                case 'E':
                case 'e':
                    vowelCount[1] += 1;
                    break;
                case 'I':
                case 'i':
                    vowelCount[2] += 1;
                    break;
                case 'O':
                case 'o':
                    vowelCount[3] += 1;
                    break;
                case 'U':
                case 'u':
                    vowelCount[4] += 1;
                    break;
            }
        }
        return vowelCount;
    }
    // This function will count the digits present in the entire string and return an array like [23,3,11,6,2,6,7,3,2,6] representing values counts for each digit respectively from [0:9].
    static int[] digitCount(String s) {
        int[] digitCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                    digitCount[0] += 1;
                    break;
                case '1':
                    digitCount[1] += 1;
                    break;
                case '2':
                    digitCount[2] += 1;
                    break;
                case '3':
                    digitCount[3] += 1;
                    break;
                case '4':
                    digitCount[4] += 1;
                    break;
                case '5':
                    digitCount[5] += 1;
                    break;
                case '6':
                    digitCount[6] += 1;
                    break;
                case '7':
                    digitCount[7] += 1;
                    break;
                case '8':
                    digitCount[8] += 1;
                    break;
                case '9':
                    digitCount[9] += 1;
                    break;
            }
        }
        return digitCount;
    }

    // This function will print all the vowels present in the string with their respective counts and it will not return anything.
    static void printVowelCounts(String s) {
        String[] vowelsList = { "A", "E", "I", "O", "U" };
        int[] vowels = vowelCount(s);
        for (int i = 0; i < vowels.length; i++) {
            System.out.println(vowelsList[i] + " --> " + vowels[i]);
        }
    }

    // This function will print all the digits present in the string with their respective counts and it will not return anything.
    static void printDigitCounts(String s) {
        String[] digitsList = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        int[] digits = digitCount(s);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digitsList[i] + " --> " + digits[i]);
        }
    }

    // This function will take a word and array of words, if the word is present in the array of words then it will return true. Else it will return false.
    static boolean findWord(String word, String[] words) {
        for (String string : words) {
            if (word.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    // This function will return a array of words with their count in decending order. Example: The function will return {"and 51","is 44","the 31"}, if the input is like {"is 44","and 51","the 31"}
    static String[] sortWordsInDescending(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                break;
            }
            String[] parts = words[i].split(" ");
            int num1 = Integer.parseInt(parts[1]);
            for (int j = 0; j < words.length; j++) {
                if (words[j] == null) {
                    break;
                }
                String[] parts1 = words[j].split(" ");
                int num2 = Integer.parseInt(parts1[1]);
                if (num1 <= num2) {
                    continue;
                } else {
                    String temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                    num1 = num2;
                }
            }
        }
        return words;
    }

    // This function will take string as the input and pass the array of words in sortWordsInDecending() so that it will return repeated words.
    static String[] wordCount(String s) {
        String[] words = s.split("[\\s,()]+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\.", "");
        }
        String[] uniqueWords = new String[words.length];
        String[] wordCount = new String[words.length];
        int[] count = new int[words.length];
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            if (findWord(words[i], uniqueWords)) {
                continue;
            } else {
                uniqueWords[i] = words[i];
                count[i] = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equalsIgnoreCase(words[j])) {
                        count[i] += 1;
                    }
                }
                wordCount[k] = words[i] + " " + count[i];
                k++;
            }

        }
        return sortWordsInDescending(wordCount);
    }

    // This function will take a character and array of character, if the character is present in the array of characters then it will return true. Else it will return false.
    static boolean findChar(char c, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == c) {
                return true;
            }
        }
        return false;
    }

    // This function will take string as the input and pass the array of words in sortWordsInDecending() so that it will return repeated characters. 
    static String[] charCount(String s) {
        s = s.toLowerCase();
        char[] uniqueChars = new char[s.length()];
        String[] charCount = new String[s.length()];
        int[] count = new int[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (findChar(s.charAt(i), uniqueChars) || s.charAt(i) == ' ') {
                continue;
            } else {
                uniqueChars[i] = s.charAt(i);
                count[i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        count[i] += 1;
                    }
                }
                charCount[k] = s.charAt(i) + " " + count[i];
                k++;
            }
        }
        return sortWordsInDescending(charCount);
    }

    // This function will print top 5 repeated words of your string.
    static void topFiveRepeatedWords(String[] s) {
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }
    }

    // This function will print last 5 repeated words of your string.
    static void lastFiveRepeatedWords(String[] s) {
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                break;
            }
            length++;
        }
        for (int i = length - 5; i < length; i++) {
            System.out.println(s[i]);
        }
    }

    // This function will print top 5 repeated characters in your string.
    static void topFiveRepeatedChars(String[] s) {
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }
    }

    // This function will print last 5 repeated characters in your string.
    static void lastFiveRepeatedChars(String[] s) {
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                break;
            }
            length++;
        }
        for (int i = length - 5; i < length; i++) {
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=======================================================================");
        String s="";
        try {
        File file=new File("text.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
        s+=scan.nextLine();
        }
        scan.close();
        } catch (Exception e) {
        System.out.println("An error occurred.");
        }
        String[] sortedWordsInDecending=wordCount(s);
        String[] sortedCharsInDecending=charCount(s);
        System.out.println("=======================================================================");
        System.out.println("Vowels:");
        System.out.println("=======================================================================");
        printVowelCounts(s);
        System.out.println("=======================================================================");
        System.out.println("Digits:");
        System.out.println("=======================================================================");
        printDigitCounts(s);
        System.out.println("=======================================================================");
        System.out.println("Top 5 Repeated Words:");
        System.out.println("=======================================================================");
        topFiveRepeatedWords(sortedWordsInDecending);
        System.out.println("=======================================================================");
        System.out.println("Last 5 Repeated Words:");
        System.out.println("=======================================================================");
        lastFiveRepeatedWords(sortedWordsInDecending);
        System.out.println("=======================================================================");
        System.out.println("Top 5 Repeated Chars:");
        System.out.println("=======================================================================");
        topFiveRepeatedChars(sortedCharsInDecending);
        System.out.println("=======================================================================");
        System.out.println("Last 5 Repeated Chars:");
        System.out.println("=======================================================================");
        lastFiveRepeatedChars(sortedCharsInDecending);
        System.out.println("=======================================================================");



                                            // PART 2 (Additional Part)


        System.out.println("=======================================================================");
        System.out.println("===============================PART 2==================================");
        System.out.println("=======================================================================");
        String content="";
        String line="";
        try {
            File file = new File("htmlFile.txt");
            // As the file is a huge file, we use BufferedReader object instead of Scanner object
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line=reader.readLine())!=null){
                content+=line;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
        }
        // Finding the starting index of Top Categories
        int start=content.indexOf("Top Categories");
        // Finding the starting index of the next section so that everything between that is included.
        int end=content.indexOf("<div class=\"trending-head\">Trending News</div>");
        // Extracting the substring from the full content.
        content=content.substring(start, end);
        // Again extracting the substrings based on our requirements.
        content=content.substring(content.indexOf("<ul"),content.indexOf("</ul>"));
        String[] items = content.split("</a>");
        content="Top Categories\n\n";
        int count=0;
        for (String item : items) {
            // Spliting the content from <a href tag as our main categories are present between the <a></a> tags.
            String[] itemSplitArray=item.split("<a href=\".*\">");
            if(itemSplitArray.length>1){
                count+=1;
                String itemName=item.split("<a href=\".*\">")[1];
                content+=count+ ") " +itemName+"\n";
            }
        }
        System.out.println(content);
        FileWriter writer=new FileWriter("Top Categories.txt");
        writer.write(content);
        writer.close();
        System.out.println("=======================================================================");
    }
}
