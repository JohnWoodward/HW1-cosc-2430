//package company;

public class HW1 {

    public static void main(String[] args) {


        String inputFile = args[0];
        String outputFile = args[1];

        FileInput toBeParsed = new FileInput(inputFile);

        HighestFrequencyWord questionOneAndTwo = new HighestFrequencyWord(toBeParsed.getWordArray(), toBeParsed.getWordCount());

        QuestionThree questionThree = new QuestionThree(toBeParsed.getSentenceArray(), toBeParsed.getSentenceCount());

        QuestionFourThroughNine getAnswers = new QuestionFourThroughNine(toBeParsed.getSentenceArray(), toBeParsed.getSentenceCount());


        FileOutput outputOne = new FileOutput(outputFile + "1.txt", questionOneAndTwo.highestFrequency());
        FileOutput outputTwo = new FileOutput(outputFile + "2.txt", questionOneAndTwo.thirdPlaceString());

        FileOutput outputThree = new FileOutput(outputFile + "3.txt", questionThree.toOutput(toBeParsed.getSentenceArray()));

        FileOutput outputFour = new FileOutput(outputFile + "4.txt", getAnswers.searchToOutput(0));
        FileOutput outputFive = new FileOutput(outputFile + "5.txt", getAnswers.searchToOutput(1));
        FileOutput outputSix = new FileOutput(outputFile + "6.txt", getAnswers.searchToOutput(2));
        FileOutput outputSeven = new FileOutput(outputFile + "7.txt", getAnswers.searchToOutput(3));
        FileOutput outputEight = new FileOutput(outputFile + "8.txt", getAnswers.searchToOutput(4));
        FileOutput outputNine = new FileOutput(outputFile + "9.txt", getAnswers.searchToOutput(5));

    }
}
