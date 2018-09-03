package company;
import java.util.ArrayList;


public class WordToSearch {
    private int wordCount;

    WordToSearch(String word, ArrayList<String> arrayToSearch, int maxIndex) {
        wordCount = 0;

        for (int i = 0; i < maxIndex; i++) {
            if (word.equals(arrayToSearch.get(i))) {
                wordCount++;

            }
        }
    }


    int countForSentence() {
        return wordCount;
    }
}
