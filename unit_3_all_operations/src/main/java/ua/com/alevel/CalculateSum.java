package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateSum {

    public void run() {
        int sum = 0;
        String input = null;
        System.out.println("Please, enter your value.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] values = input.split("");

        for (int i = 0; i < values.length; i++) {
            try {
                int digit = Integer.parseInt(values[i]);
                sum = sum + digit;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }

        System.out.println("The sum of digits in your input equals " + sum);
    }
}
