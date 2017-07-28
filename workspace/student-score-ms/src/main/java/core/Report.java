package core;

import core.Class;

public class Report {

    private Class klass;
    private String separator = "\n";

    public Report(Class klass) {
        this.klass = klass;
    }

    private StringBuilder buildScoreList() {
        StringBuilder scoreList = new StringBuilder();

        klass.getStudents().stream().map(s -> generateScoreListItem(s)).forEach(s -> scoreList.append(s).append(separator));

        return scoreList;
    }

    private String generateScoreListItem(Student student) {
            return student.getName() + "|" + student.getMathScore() + "|"
                + student.getChineseScore() + "|" + student.getEnglishScore() + "|" + student.getProgramScore()
                + "|" + student.getAverageScore() + "|" + student.getTotalScore();
    }

    public String generateScoreList() {

        String scoreListText = "成绩单" + separator
                + "姓名|数学|语文|英语|编程|平均分|总分" + separator
                + "========================" + separator;

        return scoreListText + buildScoreList()
                + "========================" + separator
                + "全班总平均分：" + klass.getTotalScore() + separator
                + "全班总分中位数：" + klass.getMedianScore() + separator;
    }
}

