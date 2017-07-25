import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Word {

    private String word = "";
    private int count = 0;

    public Word(String word, int count) {
        this.count = count;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count = this.count + 1;
    }

    public ArrayList<Word> generateWordsCountList(List<String> splitedText) {

        ArrayList<Word> wordsCountList = new ArrayList<Word>();

        for (String word : splitedText) {
            Word existWord = isExistWord(word, wordsCountList);

            if (existWord != null) {
                existWord.setCount();
            } else {
                wordsCountList.add(new Word(word, 1));
            }
        }

        return wordsCountList;
    }

    public Word isExistWord(String word, ArrayList<Word> wordsCountList) {

        for (Word object : wordsCountList) {
            if (object.getWord() == word) {
                return object;
            }
        }

        return null;
    }
}
