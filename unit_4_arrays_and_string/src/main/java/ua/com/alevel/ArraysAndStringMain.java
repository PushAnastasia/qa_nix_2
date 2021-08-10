package ua.com.alevel;

import java.util.Scanner;

public class ArraysAndStringMain {

    public static void main(String[] args) {
        String newline = System.lineSeparator();
        String prompt = "Please,select which reverse method you would like to use:"
                + newline + "To reverse the whole string - enter 1"
                + newline + "To reverse a sub string - enter 2"
                + newline + "To reverse a sub string from/to specified string indexes - enter 3"
                + newline + "To reverse a sub string from/to specified characters - enter 4"
                + newline + "To reverse a sub string from/to specified strings - enter 5"
                + newline + "To reverse a sub string from/to specified char sequence - enter 6";
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        TestReverseString test = new TestReverseString();

        switch (choice) {
            case 1:
                test.reverseWholeString();
                break;
            case 2:
                test.reverseSubString();
                break;
            case 3:
                test.reverseForIndexes();
                break;
            case 4:
                test.reverseForChars();
                break;
            case 5:
                test.reverseForStrings();
                break;
            case 6:
                test.reverseForCharSequence();
                break;
        }
    }
}
