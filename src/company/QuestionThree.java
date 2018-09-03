<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
//package company;

=======
package company;
>>>>>>> parent of 3e1b4d7... Finish queston 4-9
=======
package company;
>>>>>>> parent of 3e1b4d7... Finish queston 4-9
=======
package company;
>>>>>>> parent of 3e1b4d7... Finish queston 4-9
=======
package company;
>>>>>>> parent of 3e1b4d7... Finish queston 4-9
import java.util.ArrayList;

public class QuestionThree {
    private String currentSentence;
    private ArrayList<String> word;
    private String[] sentenceArray;
    private String [] answerSplit;
    private int wordCount;
    private int highestCount;
    private String mostFrequentWord;
    private int currentCount;
    private int sentenceIndex;
    private ArrayList<String> ifMultiple;
    private int multiSentenceCount;
    private ArrayList<Integer> ifMultipleIndex;

    QuestionThree(ArrayList<String> sentenceList, int maxIndex) {

        word = new ArrayList<>();
        ifMultiple = new ArrayList<>();
        ifMultipleIndex = new ArrayList<>();
        wordCount = 0;
        highestCount = 0;
        mostFrequentWord = "";
        multiSentenceCount = 0;


        for (int i = 0; i < maxIndex; i++) {
            currentSentence = sentenceList.get(i);
            word.clear();
            wordCount = 0;

            sentenceArray = currentSentence.split("\\s*(=>|[.]|\\s)\\s*");

            for (String currentWord : sentenceArray) {
                word.add(currentWord.toLowerCase());
                wordCount++;
            }

            HighestFrequencyWord questionThree = new HighestFrequencyWord(word, wordCount);
            answerSplit = questionThree.highestFrequency().split("\\s*(=>|[:]|\\s)\\s*");
            currentCount = Integer.parseInt(answerSplit[1]);
            if (highestCount <= currentCount) {
                if (currentCount == highestCount) {
                    ifMultiple.add(questionThree.highestFrequency());
                    ifMultipleIndex.add(i);
                    multiSentenceCount++;

                } else {
                    ifMultiple.clear();
                    ifMultipleIndex.clear();
                    multiSentenceCount = 0;
                    highestCount = currentCount;
                    ifMultiple.add(questionThree.highestFrequency());
                    ifMultipleIndex.add(i);

                }

            }

        }
    }

    String toOutput (ArrayList<String> list) {
        String stringToOutput = "";

        for (int i = 0; i <= multiSentenceCount; i++) {
            stringToOutput += (ifMultiple.get(i) + " : " + list.get(ifMultipleIndex.get(i)) + "\n");
        }
        return stringToOutput;
    }
}
