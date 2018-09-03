package company;

import java.util.ArrayList;

public class QuestionFourThroughNine {
    private String currentSentence;
    private ArrayList<String> word;
    private String[] sentenceArray;
    private int wordCount;
    private int highestCount;
    private int currentCount;
    private int multiSentenceCount;
    private ArrayList<Integer> ifMultipleIndex;
    private ArrayList<String> wordsToFind;
    private ArrayList<String> wordsFound;
    private String stringStore;
    private int singleIndex;

    QuestionFourThroughNine(ArrayList<String> sentenceList, int maxIndex) {

        wordsToFind = new ArrayList<>();
        wordsFound = new ArrayList<>();
        ifMultipleIndex = new ArrayList<>();
        word = new ArrayList<>();

        wordsToFind.add("the");
        wordsToFind.add("of");
        wordsToFind.add("was");
        wordsToFind.add("but the");
        wordsToFind.add("it was");
        wordsToFind.add("in my");


        for (int n = 0; n < 6; n++) {
            highestCount = 0;
            answerSplit = 0;
            multiSentenceCount = 0;
            ifMultipleIndex.clear();
            stringStore = "";
            singleIndex = 0;


            for (int i = 0; i < maxIndex; i++) {
                currentSentence = sentenceList.get(i);
                word.clear();
                wordCount = 0;


                sentenceArray = currentSentence.split("\\s*(=>|[.]|\\s)\\s*");

                for (String currentWord : sentenceArray) {
                    word.add(currentWord.toLowerCase());
                    wordCount++;
                }

//                WordToSearch currentQuestion = new WordToSearch(wordsToFind.get(n), word, wordCount);
                currentCount = currentQuestion.countForSentence();

                for (int k = 0; k < maxIndex; k++) {


                    if (word.equals(wordsToFind.get(i))) {
                        if (highestCount > 0) {

                            if (highestCount <= currentCount) {
                                if (currentCount == highestCount) {

                                    ifMultipleIndex.add(i);
                                    multiSentenceCount++;


                                } else {
                                    ifMultipleIndex.clear();
                                    multiSentenceCount = 0;
                                    singleIndex = i;
                                    highestCount = currentCount;
                                }

                            }
                        }
                    }

                }
            }
            if ((highestCount) == 0) {
                wordsFound.add("No Matches Found!");
                System.out.println("No Matches Found!");
            } else if (multiSentenceCount == 0) {
                stringStore += (wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(singleIndex) + "\n");
            } else {
                for (int i = 0; i < multiSentenceCount; i++) {
                    stringStore += (wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(ifMultipleIndex.get(i)) + "\n");
                }
            }
            wordsFound.add(stringStore);
        }
//            else if (singleMatch > 0) {
//                wordsFound.add(wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(singleIndex));
//
//            }
//            wordsFound.add("No matches Found");


    }


    String searchToOutput(int index) {
        return wordsFound.get(index);
    }
}
