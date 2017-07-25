import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FileTextTest {
    @Test
    public void read_file_content_when_given_a_file() throws Exception {

        String fileName = "../../wordsText.txt";
        String content = new FileText().getFileContent(fileName);

        System.out.println(content);

        assertThat(content,is("the day is sunny the the\nthe sunny is is"));
    }
}
