package company;
import java.util.ArrayList;

public class HighestFrequencyWord {
    private int uniqueWordCount;
    private int currentHighestCount;
    private ArrayList <String> word;
    private ArrayList <Integer> frequency;

    private int highestCountIndex = 0;
    private String highestCountString;



    HighestFrequencyWord(ArrayList<String> wordList, int maxIndex) {

        word = new ArrayList<>();
        frequency = new ArrayList<>();
        String currentWord;
        uniqueWordCount = 0;
        Boolean wordBool;


        for (int i = 0; i < maxIndex; i++) {
            wordBool = false;
            currentWord = wordList.get(i);

            if (uniqueWordCount > 0) {

                for (int n = 0; n < uniqueWordCount; n++) {
                    if (currentWord.toLowerCase().equals(word.get(n))) {
                        frequency.set(n, (frequency.get(n)) + 1);
                        wordBool = true;
                    }
                }

                if (!wordBool) {
                    word.add(currentWord.toLowerCase());
                    frequency.add(1);
                    uniqueWordCount++;
                }
            } else {
                word.add(currentWord.toLowerCase());
                frequency.add(1);
                uniqueWordCount++;
            }
        }
    }

    String highestFrequency() {
        currentHighestCount = 0;
        int highestCountIndex = 0;
        String highestCountString;

        for (int i = 0; i < uniqueWordCount; i++) {
            if (frequency.get(i) > currentHighestCount) {
                currentHighestCount = frequency.get(i);
                highestCountIndex = i;
            }
        }
        highestCountString = word.get(highestCountIndex) + ":" + currentHighestCount;

        return highestCountString;
    }

    String thirdPlaceString() {

        int secondHighestCount = 0;
        int thirdHighestCount = 0;
        int thirdCountIndex = 0;
        String thirdPlaceString;

        for (int i = 0; i < uniqueWordCount; i++) {
            if (currentHighestCount > frequency.get(i) && frequency.get(i) > secondHighestCount ) {
                secondHighestCount = frequency.get(i);
            }
        }

        for (int i = 0; i < uniqueWordCount; i++) {
            if (secondHighestCount > frequency.get(i) && frequency.get(i) > thirdHighestCount) {
                thirdHighestCount = frequency.get(i);
                thirdCountIndex = i;
            }
        }
        thirdPlaceString = word.get(thirdCountIndex) + " : " + thirdHighestCount;

        return thirdPlaceString;
    }

}
