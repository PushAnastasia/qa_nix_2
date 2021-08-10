package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class SortedCharacters {

    public void run() {
        String input = null;
        System.out.println("Please, enter your value.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] chars = input.toCharArray();
        TreeMap<Character, Integer> charCount = new TreeMap<Character, Integer>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (charCount.containsKey(chars[i])) {
                    charCount.put(chars[i], (charCount.get(chars[i]) + 1));
                } else {
                    charCount.put(chars[i], 1);
                }
            }
        }

        for (Character key : charCount.keySet()) {
            System.out.println(key + " - " + charCount.get(key));
        }
    }
}
