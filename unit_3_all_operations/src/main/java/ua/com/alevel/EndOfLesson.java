package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndOfLesson {
    public void run() {
        int lessonsStartHour = 9;
        int lessonLengthMinutes = 45;
        int oddBreakLengthMinutes = 5;
        int evenBreakLengthMinutes = 15;
        int lessonsCount = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (lessonsCount < 1 || lessonsCount > 10) {
            System.out.println("Please, enter the number of lesson from 1 to 10.");
            try {
                input = bufferedReader.readLine();
                lessonsCount = Integer.parseInt(input);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        int breakCount = lessonsCount - 1;
        int evenBreakCount = breakCount / 2;
        int oddBreackCount = breakCount - evenBreakCount;
        int totalMinutesInSchool = lessonsCount * lessonLengthMinutes + oddBreackCount * oddBreakLengthMinutes +
                evenBreakCount * evenBreakLengthMinutes;

        int endHour = lessonsStartHour + totalMinutesInSchool / 60;
        int endMinutes = totalMinutesInSchool % 60;

        System.out.println(String.format("The end of the lesson is at %d:%02d", endHour, endMinutes));
    }
}
