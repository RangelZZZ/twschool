import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordTest {


    @Test
    public void should_calculate_word_countand_return_wordCount_arrayList_when_input_list_of_list() throws Exception {

        List<String> splitedText = Arrays.asList("the","the","is","the","is");


        ArrayList<Word> wordsCountList = new Word("",0).generateWordsCountList(splitedText);

        assertThat(wordsCountList.get(0).getWord(),is("the"));
        assertThat(wordsCountList.get(0).getCount(),is(3));
        assertThat(wordsCountList.get(1).getCount(),is(2));
    }
}