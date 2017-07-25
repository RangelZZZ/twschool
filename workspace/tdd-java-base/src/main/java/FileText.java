import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileText {
    public String getFileContent(String fileName) throws FileNotFoundException {

        return new Scanner(new java.io.File(fileName)).useDelimiter("\\Z").next();

    }
}