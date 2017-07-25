import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordTest {


    @Test
    public void should_calculate_word_countand_return_wordCount_arrayList_when_input_word_list() throws Exception {

        List<String> splitedText = Arrays.asList("the");


        ArrayList<Word> wordsCountList = new Word("",0).generateWordsCountList(splitedText);

        assertThat(wordsCountList.get(0).getWord(),is("the"));
        assertThat(wordsCountList.get(0).getCount(),is(1));
    }
}