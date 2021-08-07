package ua.com.alevel;

import java.util.Scanner;

public class testReverseString {
    reverseString reverseString = new reverseString();
    Scanner scanner = new Scanner(System.in);

    public void reverseWholeString() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println
                ("Enter 'true' if the whole string should be reverted or 'false' if each word should be reverted.");
        boolean reverseType = askForBoolean();
        String result = reverseString.reverse(input, reverseType);
        System.out.println("Reversed string: " + result);
    }

    public void reverseSubString() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println("Please, enter a sub string.");
        String subString = askForString();
        String result = reverseString.reverse(input, subString);
        System.out.println("String with reversed substring: " + result);
    }

    public void reverseForIndexes() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println("Enter the first index.");
        int firstIndex = askForInteger();
        System.out.println("Enter the last index.");
        int lastIndex = askForInteger();
        String result = reverseString.reverse(input, firstIndex, lastIndex);
        System.out.println("String with reversed substring for specified indexes: " + result);
    }

    public void reverseForChars() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println("Enter the first character.");
        char firstChar = askForChar();
        System.out.println("Enter the last character.");
        char lastChar = askForChar();
        String result = reverseString.reverse(input, firstChar, lastChar);
        System.out.println("String with reversed substring for specified characters: " + result);
    }

    public void reverseForStrings() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println("Please, enter the start string.");
        String startString = askForString();
        System.out.println("Please, enter the finish string.");
        String finishString = askForString();
        String result = reverseString.reverse(input, startString, finishString);
        System.out.println("String with reversed substring for specified start/end strings: " + result);
    }

    public void reverseForCharSequence() {
        System.out.println("Please, enter a string.");
        String input = askForString();
        System.out.println("Enter start char sequence.");
        CharSequence startChars = askForCharSequence();
        System.out.println("Enter end char sequence.");
        CharSequence endChars = askForCharSequence();
        String result = reverseString.reverse(input, startChars, endChars);
        System.out.println("String with reversed substring for specified start/end char sequences: " + result);
    }

    public String askForString() {
        String input = scanner.nextLine();
        return input;
    }

    public boolean askForBoolean() {
        boolean b = scanner.nextBoolean();
        return b;
    }

    public int askForInteger() {
        int number = scanner.nextInt();
        return number;
    }

    public char askForChar() {
        String input = scanner.nextLine();
        char singleChar = input.toCharArray()[0];
        return singleChar;
    }

    public CharSequence askForCharSequence() {
        CharSequence input = scanner.nextLine();
        return input;
    }
}
