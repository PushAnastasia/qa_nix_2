package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;
import ua.com.alevel.util.TextAnalyzer;

import java.io.*;
import java.util.HashSet;
import java.util.Map;

public class FileServiceImpl implements FileService {

    @Override
    public void create(FileModel fileModel) {
        File file = new File(fileModel.getName() + "." + fileModel.getExtensionType().getExtension());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(fileModel.getContent());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public String read(String fileName) {
        String content = "";
        File file = new File(fileName);
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            String line = lineNumberReader.readLine();
            while (line != null) {
                content = content.concat(line).concat(" ");
                line = lineNumberReader.readLine();
            }
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getOutput(String input) {
        String output = "The text contains following words:\n";
        Map<String, Integer> wordsCount = TextAnalyzer.getWordsCount(input);
        for (String key : wordsCount.keySet()) {
            output = output.concat(key + " - " + wordsCount.get(key) + "\n");
        }
        output = output.concat("\nPalindromes:\n");
        HashSet<String> palindromes = TextAnalyzer.getPalindrome(input);
        for (String palindrome : palindromes) {
            output = output.concat(palindrome + " - " + wordsCount.get(palindrome) + "\n");
        }
        output = output.concat("\nThe amount of sentences is " + TextAnalyzer.getSentenceCount(input));
        return output;
    }
}
