import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParseUtilTest {
    private ParseUtil parseUtil;

    @Test
    public void should_parse_string_to_array_when_input_a_string() throws Exception {

        String text = "the day is sunny the the the sunny is is";

        List<String> splitedText = new ParseUtil().splitText(text);

        assertThat(splitedText.get(0), is("the"));
        assertThat(splitedText.get(2),is("is"));

    }
}
