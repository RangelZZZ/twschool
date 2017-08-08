package core;

public class ReportItem {
    private String name;
    private int mathScore;
    private int englishScore;
    private int programScore;
    private int chineseScore;

    public ReportItem(Student student) {
        this.name = student.getName();
        this.mathScore = student.getMathScore();
        this.chineseScore = student.getChineseScore();
        this.englishScore = student.getEnglishScore();
        this.programScore = student.getProgramScore();
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getProgramScore() {

        return programScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
    }

    public int getEnglishScore() {

        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMathScore() {

        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
