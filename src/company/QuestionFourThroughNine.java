//package company;

import java.util.ArrayList;

public class QuestionFourThroughNine {
    private String currentSentence;
    private ArrayList<String> word;
    private String[] sentenceArray;
    private int wordCount;
    private int highestCount;
    private ArrayList<Integer> wordFoundIndex;
    private ArrayList<String> wordsToFind;
    private ArrayList<String> wordsFound;
    private String stringStore;
    private int matchesFoundCount;
    private int wordsFoundCount;

    QuestionFourThroughNine(ArrayList<String> sentenceList, int maxIndex) {

        wordsToFind = new ArrayList<>();
        wordsFound = new ArrayList<>();
        wordFoundIndex = new ArrayList<>();
        word = new ArrayList<>();

        wordsToFind.add("the");
        wordsToFind.add("of");
        wordsToFind.add("was");
        wordsToFind.add("but the");
        wordsToFind.add("it was");
        wordsToFind.add("in my");


        for (int n = 0; n < 6; n++) {
            highestCount = 0;
            wordFoundIndex.clear();
            stringStore = "";
            matchesFoundCount = 0;
            String currentWordToFind = wordsToFind.get(n);
            matchesFoundCount = 0;


            for (int i = 0; i < maxIndex; i++) {
                currentSentence = sentenceList.get(i);
                word.clear();
                wordCount = 0;
                wordsFoundCount = 0;

                sentenceArray = currentSentence.split("\\s*(=>|[.]|\\s)\\s*");

                for (String currentWord : sentenceArray) {
                    word.add(currentWord.toLowerCase());
                    wordCount++;
                }


                for (int k = 0; k < wordCount; k++) {


                    if (k > 0) {
                        if (currentWordToFind.equals(word.get(k)) || currentWordToFind.equals(word.get(k - 1) + " " + word.get(k))) {

                            wordsFoundCount++;
                            if (highestCount < wordsFoundCount) {
                                wordFoundIndex.clear();
                                wordFoundIndex.add(i);
                                highestCount = wordsFoundCount;
                                matchesFoundCount = 1;
                            } else if (highestCount == wordsFoundCount) {
                                wordFoundIndex.add(i);
                                matchesFoundCount++;


                            }
                        }
                    } else if (word.equals(wordsToFind.get(k))) {
                        wordFoundIndex.add(i);
                        highestCount = wordsFoundCount;
                        matchesFoundCount++;

                    }
                }


            }

            if (matchesFoundCount == 0) {
                for (int k = 0; k < maxIndex; k++) {
                    stringStore += (wordsToFind.get(n) + ":" + highestCount + ":" + sentenceList.get(k).replaceAll("\\.", "") + "\n");
                }
            } else {
                for (int j = 0; j < matchesFoundCount; j++) {
                    if (matchesFoundCount > 0) {

                        stringStore += (wordsToFind.get(n) + ":" + highestCount + ":" + sentenceList.get(wordFoundIndex.get(j)).replaceAll("\\.", "") + "\n");
                    } else {
                        for (int k = 0; k < maxIndex; k++) {

                        }
                    }

                }

            }
            wordsFound.add(stringStore);
        }


    }


    String searchToOutput(int index) {
        return wordsFound.get(index);
    }
}
