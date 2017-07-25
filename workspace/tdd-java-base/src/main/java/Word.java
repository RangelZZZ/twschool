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

    public ArrayList<Word> generateWordsCountList(List<String> splitedText) {

        ArrayList<Word> wordsCountList = new ArrayList<Word>();

        for (String word : splitedText) {
            if (isExist(word, wordsCountList)) {
                this.count++;
            } else {
                wordsCountList.add(new Word(word,1));

            }
        }

        return wordsCountList;

    }

    public Boolean isExist(String word, ArrayList<Word> wordsCountList) {

        for(Word word1:wordsCountList){
            if(word1.getWord() == word){
                return true;
            }
        }

        return false;
    }
}
