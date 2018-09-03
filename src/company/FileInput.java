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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInput {





        private ArrayList<String> scentence;
        private ArrayList<String> word;
        private int lineCount;
        private int wordCount;




        FileInput(String inputFile) {

            String[] currentSentenceArray;
            String[] currentLineArray;
            String currentLine;

            scentence = new ArrayList<>();
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 3e1b4d7... Finish queston 4-9

                        scentence.add(currentSentence);
                        lineCount++;
                    }
<<<<<<< HEAD
>>>>>>> parent of 3e1b4d7... Finish queston 4-9
=======
>>>>>>> parent of 3e1b4d7... Finish queston 4-9

                        scentence.add(currentSentence);
                        lineCount++;
                    }

<<<<<<< HEAD
<<<<<<< HEAD

                    currentLineArray = currentLine.split("\\s*(=>|[.]|\\s)\\s*");

=======
                    currentLineArray = currentLine.split("\\s*(=>|[.]|\\s)\\s*");

>>>>>>> parent of 3e1b4d7... Finish queston 4-9
=======
                    currentLineArray = currentLine.split("\\s*(=>|[.]|\\s)\\s*");

>>>>>>> parent of 3e1b4d7... Finish queston 4-9
                    for (String currentWord : currentLineArray) {
                        word.add(currentWord.toLowerCase());
                        wordCount++;
                    }
                }
                fr.close();
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> getSentenceArray() {
            return scentence;
        }
        int getSentenceCount() {
            return lineCount;
        }

        ArrayList<String> getWordArray() {
            return word;
        }
        int getWordCount () {
            return wordCount;
        }
}
