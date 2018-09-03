//package company;

import java.util.ArrayList;

public class QuestionFourThroughNine {
    private String currentSentence;
    private ArrayList<String> word;
    private String[] sentenceArray;
    private int wordCount;
    private int highestCount;
    private int currentCount;
    private int multiSentenceCount;
    private ArrayList<Integer> wordFoundIndex;
    private ArrayList<String> wordsToFind;
    private ArrayList<String> wordsFound;
    private String stringStore;
    private int singleIndex;
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
            multiSentenceCount = 0;
            wordFoundIndex.clear();
            stringStore = "";
            singleIndex = 0;
            matchesFoundCount = 0;
            String currentWordToFind = wordsToFind.get(n);
            matchesFoundCount = 0;


            for (int i = 0; i < maxIndex; i++) {
                currentSentence = sentenceList.get(i);
                currentCount = 0;
                word.clear();
                wordCount = 0;


                wordsFoundCount = 0;


                sentenceArray = currentSentence.split("\\s*(=>|[.]|\\s)\\s*");

                for (String currentWord : sentenceArray) {
                    word.add(currentWord.toLowerCase());
                    wordCount++;
                }

//                WordToSearch currentQuestion = new WordToSearch(wordsToFind.get(n), word, wordCount);
//                currentCount = currentQuestion.countForSentence();

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

            for (int j = 0; j < matchesFoundCount; j++) {
                if (matchesFoundCount > 0) {

                    stringStore += (wordsToFind.get(n) + ":" + highestCount + ":" + sentenceList.get(wordFoundIndex.get(j)) + "\n");
                }
                else {
                    for (int k = 0; k < maxIndex; k++) {
                        stringStore += (wordsToFind.get(n) + ":" + highestCount + ":" + sentenceList.get(k) + "\n");
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


//                                if (highestCount <= currentCount) {
//                                    if (currentCount == highestCount) {
//
//                                        wordFoundIndex.add(i);
//                                        wordFoundCount++1;
//                                        multiSentenceCount++;
//
//
//                                    } else {
//                                        wordFoundIndex.clear();
//                                        multiSentenceCount = 0;
//                                        singleIndex = i;
//                                        highestCount = currentCount;
//                                    }

//                                }
//                            }
//                        }
//                    }

//
//                }
//            }
//            if ((highestCount) == 0) {
//                wordsFound.add("No Matches Found!");
//                System.out.println("No Matches Found!");
//            } else if (multiSentenceCount == 0) {
//                stringStore += (wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(singleIndex) + "\n");
//            } else {
//                for (int i = 0; i < multiSentenceCount; i++) {
//                    stringStore += (wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(wordFoundIndex.get(i)) + "\n");
//                }
//            }
//            wordsFound.add(stringStore);
//        }
////            else if (singleMatch > 0) {
////                wordsFound.add(wordsToFind.get(n) + " : " + highestCount + " : " + sentenceList.get(singleIndex));
////
////            }
////            wordsFound.add("No matches Found");
//
//
//    }


//    String searchToOutput(int index) {
//        return wordsFound.get(index);
//    }
//}
