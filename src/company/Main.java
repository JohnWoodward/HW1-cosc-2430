package company;

public class Main {

    public static void main(String[] args) {
        String inputFile = "tiny1.txt";

        FileInput toBeParsed = new FileInput(inputFile);

        HighestFrequencyWord questionOneAndTwo = new HighestFrequencyWord(toBeParsed.getWordArray(), toBeParsed.getWordCount());

        QuestionThree questionThree = new QuestionThree(toBeParsed.getSentenceArray(), toBeParsed.getSentenceCount());

        QuestionFourThroughNine getAnswers = new QuestionFourThroughNine(toBeParsed.getSentenceArray(), toBeParsed.getSentenceCount());


        FileOutput outputOne = new FileOutput("output1.txt", questionOneAndTwo.highestFrequency());
        FileOutput outputTwo = new FileOutput("output2.txt", questionOneAndTwo.thirdPlaceString());

        FileOutput outputThree = new FileOutput("output3.txt", questionThree.toOutput(toBeParsed.getSentenceArray()));

        FileOutput outputFour = new FileOutput("output4.txt", getAnswers.searchToOutput(0));
        FileOutput outputFive = new FileOutput("output5.txt", getAnswers.searchToOutput(1));
        FileOutput outputSix = new FileOutput("output6.txt", getAnswers.searchToOutput(2));
        FileOutput outputSeven = new FileOutput("output7 .txt", getAnswers.searchToOutput(3));
        FileOutput outputEight = new FileOutput("output8.txt", getAnswers.searchToOutput(4));
        FileOutput outputNine = new FileOutput("output9.txt", getAnswers.searchToOutput(5));

    }
}
