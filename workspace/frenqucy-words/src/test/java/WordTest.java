import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordTest {


    @Test
    public void should_calculate_word_count_and_return_wordCount_arrayList_when_input_list_of_list() throws Exception {
        List<String> splitedText = Arrays.asList("the", "the", "is", "the", "is");

        ArrayList<Word> wordsCountList = new Word("", 0).generateWordsCountList(splitedText);

        assertThat(wordsCountList.get(0).getWord(), is("the"));
        assertThat(wordsCountList.get(0).getCount(), is(3));
        assertThat(wordsCountList.get(1).getCount(), is(2));
    }

    @Test
    public void should_sort_words_and_return_sorted_list_when_input_words_count_list() throws Exception {
        ArrayList<Word> wordsCountList = new ArrayList<Word>();
        wordsCountList.add(new Word("the", 4));
        wordsCountList.add(new Word("is", 6));

        ArrayList<Word> sortedWordList = new Word("", 0).sortWordCountList(wordsCountList);

        assertThat(sortedWordList.get(0).getWord(), is("is"));
        assertThat(sortedWordList.get(1).getWord(), is("the"));
    }

    @Test
    public void should_print_string_of_words_and_count_when_input_sortrd_word_list() throws Exception {
        ArrayList<Word> sortedWordList = new ArrayList<Word>();
        sortedWordList.add(new Word("is", 6));
        sortedWordList.add(new Word("the", 4));

        String sortedWordText = new Word("", 0).printWordText(sortedWordList);

        assertThat(sortedWordText,is("is 6\nthe 4"));
    }
}