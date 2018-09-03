package company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class FileOutput {
    FileOutput(String outputFilePath, String textToBeWritten) {
        PrintWriter outputStream;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream(outputFilePath));
            outputStream.println(textToBeWritten);
            outputStream.close();
        }
        catch(FileNotFoundException e)
        { System.out.println("File "+outputFilePath+"cannot be found.");
            System.exit(1);
        }
    }
}
