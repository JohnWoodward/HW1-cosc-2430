package company;

import java.util.ArrayList;

public class PairsToSearch {
    private int wordCount;

    PairsToSearch(String word, ArrayList<String> arrayToSearch, int maxIndex) {
        wordCount = 0;

        for (int i = 0; i < maxIndex; i++) {
            if (i > 0) {
                if (word.equals(arrayToSearch.get(i - 1) + " " + arrayToSearch.get(i))) {
                    wordCount++;

                }
            }
        }
    }

    int countForSentence() {
        return wordCount;
    }
}
