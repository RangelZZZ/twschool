package core;

public class Grade {
    private String name;
    private String studentId;
    private int mathScore = 0;
    private int chineseScore = 0;
    private int englishScore = 0;
    private int programScore = 0;

    public Grade(){

    }

    public Grade(String name, String id, int mathScore, int chineseScore, int englishScore, int programScore) {
        this.name = name;
        this.studentId = id;
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }



    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
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

    public void setStudentId(String id) {
        this.studentId = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
    }
}
