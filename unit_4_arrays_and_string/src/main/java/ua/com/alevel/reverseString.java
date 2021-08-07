package ua.com.alevel;

public class reverseString {
    public static String reverse(String src, boolean reverseAll) {
        String result = "";
        if (reverseAll) {
            result = reverseWord(src);
        } else {
            String words[] = src.split(" ");
            result = src;
            for (int i = 0; i < words.length; i++) {
                String revertedWord = reverseWord(words[i]);
                result = result.replace(words[i], revertedWord);
            }
        }
        return result;
    }

    public static String reverse(String src, String dest) {
        String reversedDest = reverseWord(dest);
        String result = src.replace(dest, reversedDest);
        return result;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String dest = "";
        dest = src.substring(firstIndex, (lastIndex + 1));
        String reversedDest = reverseWord(dest);
        String result = src.replace(dest, reversedDest);
        return result;
    }

    public static String reverse(String src, char firstChar, char lastChar) {
        int firstIndex = src.indexOf(firstChar);
        int lastIndex = src.lastIndexOf(lastChar);
        String result = reverse(src, firstIndex, lastIndex);
        return result;
    }

    public static String reverse(String src, String start, String finish) {
        int firstIndex = src.indexOf(start);
        int lastIndex = src.lastIndexOf(finish) + finish.length() - 1;
        String result = reverse(src, firstIndex, lastIndex);
        return result;
    }

    public static String reverse(String src, CharSequence startChars, CharSequence endChars) {
        String firstSequence = String.valueOf(startChars);
        String lastSequence = String.valueOf(endChars);
        String result = reverse(src, firstSequence, lastSequence);
        return result;
    }

    public static String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = word.toCharArray();
        String result = "";
        for (int i = (word.length() - 1); i > -1; i--) {
            result = String.valueOf(stringBuilder.append(chars[i]));
        }
        return result;
    }
}
