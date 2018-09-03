package company;

import java.util.ArrayList;

public class Question6 {
    private String currentSentence;
    private ArrayList<String> word;
    private String[] sentenceArray;
    private int answerSplit;
    private int wordCount;
    private int highestCount;
    private int currentCount;
    private int multiSentenceCount;
    private ArrayList<Integer> ifMultipleIndex;
    private ArrayList<String> pairToFind;
    private ArrayList<String> pairsFound;
    private String stringStore;
    private int singleIndex;

    Question6(ArrayList<String> sentenceList, int maxIndex) {
        pairToFind = new ArrayList<>();
        pairsFound = new ArrayList<>();
        ifMultipleIndex = new ArrayList<>();
        word = new ArrayList<>();


        pairToFind.add("but the");
        pairToFind.add("it was");
        pairToFind.add("in my");

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

                PairsToSearch currentQuestion = new PairsToSearch(pairToFind.get(n), word, wordCount);
                currentCount = currentQuestion.countForSentence();
//                if (currentCount == 0) {
//                    highestCount = currentCount;
//                }
                if (highestCount <= currentCount) {
                    if (currentCount == highestCount) {
                        singleIndex = 0;
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
            if ((highestCount ) == 0) {
                pairsFound.add("No Matches Found!");
                System.out.println("No Matches Found!");
            }

            else if (multiSentenceCount == 0) {
                stringStore += (pairToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(singleIndex) + "\n");
            }

            else {
                for (int i = 0; i < multiSentenceCount; i++) {
                    stringStore += (pairToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(ifMultipleIndex.get(i)) + "\n");
                }
            }
            pairsFound.add(stringStore);
        }
    }




    String searchToOutput (int index) {
        return pairsFound.get(index);
    }
}
