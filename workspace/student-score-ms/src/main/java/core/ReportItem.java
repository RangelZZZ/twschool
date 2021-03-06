package core;

public class ReportItem {

    private String studentId;
    private String name;
    private int mathScore;
    private int englishScore;
    private int programScore;
    private int chineseScore;

    public ReportItem(Grade student) {
        this.name = student.getName();
        this.mathScore = student.getMathScore();
        this.chineseScore = student.getChineseScore();
        this.englishScore = student.getEnglishScore();
        this.programScore = student.getProgramScore();
        this.studentId = student.getStudentId();
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

    public int getTotalScore() {
        return getChineseScore() + getEnglishScore() + getMathScore() + getProgramScore();
    }

    public int getAverageScore() {
        return getTotalScore() / 4;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
