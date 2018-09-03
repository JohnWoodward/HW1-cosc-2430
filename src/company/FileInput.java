//package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInput {


    private ArrayList<String> sentence;
    private ArrayList<String> word;
    private int lineCount;
    private int wordCount;


    FileInput(String inputFile) {

        String[] currentSentenceArray;
        String[] currentLineArray;
        String currentLine;

        sentence = new ArrayList<>();
        word = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        lineCount = 0;
        wordCount = 0;

        try {

            fr = new FileReader(inputFile);
            br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {

                currentSentenceArray = currentLine.split("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?)\\s");

                for (String currentSentence : currentSentenceArray) {

                    sentence.add(currentSentence);
                    lineCount++;
                }


                currentLineArray = currentLine.split("\\s*(=>|[.]|\\s)\\s*");

                for (String currentWord : currentLineArray) {
                    word.add(currentWord.toLowerCase());
                    wordCount++;
                }
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> getSentenceArray() {
        return sentence;
    }

    int getSentenceCount() {
        return lineCount;
    }

    ArrayList<String> getWordArray() {
        return word;
    }

    int getWordCount() {
        return wordCount;
    }
}
