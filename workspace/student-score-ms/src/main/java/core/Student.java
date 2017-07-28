package core;

public class Student {
    private String name;
    private String id;
    private int mathScore = 0;
    private int chineseScore = 0;
    private int englishScore = 0;
    private int programScore = 0;

    public Student(String name, String id, int mathScore, int chineseScore, int englishScore, int programScore) {
        this.name = name;
        this.id = id;
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getProgramScore() {
        return programScore;
    }

    public int getTotalScore() {
        return getChineseScore() + getEnglishScore() + getMathScore() + getProgramScore();
    }

    public int getAverageScore() {
        return getTotalScore() / 4;
    }

}
