import java.util.*;

public class Word {

    private String word = "";
    private int count = 0;

    public Word(String word, int count) {
        this.count = count;
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void increaseCountByOne() {
        this.count = this.count + 1;
    }

    public ArrayList<Word> generateWordsCountList(List<String> splitedText) {

        ArrayList<Word> wordsCountList = new ArrayList<Word>();

        for (String word : splitedText) {
            Word existWord = isExistWord(word, wordsCountList);

            if (existWord != null) {
                existWord.increaseCountByOne();
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
    public ArrayList<Word> sortWordCountList(ArrayList<Word> wordsCountList) {

        Collections.sort(wordsCountList, new Comparator<Word>() {

            @Override
            public int compare(Word o1, Word o2) {
                return o2.getCount() - o1.getCount();
            }
        });

        return wordsCountList;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.word, this.count);
    }

    public String printWordText(ArrayList<Word> sortedWordList) {
        String sortedWordsText = "";

        for (Word word : sortedWordList) {
            if (sortedWordList.indexOf(word) == sortedWordList.size() - 1) {
                sortedWordsText += word.toString();
            } else {
                sortedWordsText += word.toString() + "\n";
            }
        }

        return sortedWordsText;
    }
}
