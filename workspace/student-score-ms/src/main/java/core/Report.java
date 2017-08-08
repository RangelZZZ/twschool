package core;

import util.Constant;

import java.util.ArrayList;

public class Report {

    private Class klass;

    public Report(Class klass) {
        this.klass = klass;
    }

    private StringBuilder buildScoreList(ArrayList<Student> selectedStudents) {
        StringBuilder scoreList = new StringBuilder();
        selectedStudents.stream().map(s -> generateScoreListItem(s)).forEach(s -> scoreList.append(s).append(Constant.SEPARATOR));

        return scoreList;
    }

    private String generateScoreListItem(Student student) {
        return student.getName() + "|" + student.getMathScore() + "|"
                + student.getChineseScore() + "|" + student.getEnglishScore() + "|" + student.getProgramScore()
                + "|" + student.getAverageScore() + "|" + student.getTotalScore();
    }

//    public String generateScoreList(ArrayList<String> studentIds) {
//        ArrayList<Student> selectedStudents = (ArrayList<Student>) klass.getSelectedStudents(studentIds);
//
//
//        String scoreListText = "成绩单" + Constant.SEPARATOR
//                + "姓名|数学|语文|英语|编程|平均分|总分" + Constant.SEPARATOR
//                + "========================" + Constant.SEPARATOR;
//
//        return scoreListText + buildScoreList(selectedStudents)
//                + "========================" + Constant.SEPARATOR
//                + "全班总平均分：" + klass.getTotalScore(selectedStudents) + Constant.SEPARATOR
//                + "全班总分中位数：" + klass.getMedianScore(selectedStudents) + Constant.SEPARATOR;
//    }
}

