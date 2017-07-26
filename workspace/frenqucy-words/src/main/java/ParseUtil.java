import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public List<String> splitText(String text) {
        String[] splitedText = text.split(" ");

        return Arrays.asList(splitedText);
    }
}
