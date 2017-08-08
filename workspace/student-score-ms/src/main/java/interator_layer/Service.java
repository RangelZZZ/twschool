package interator_layer;

import core.Class;
import core.Report;
import core.Student;
import util.Constant;
import util.ParseUtil;

import java.util.ArrayList;
import java.util.Scanner;



public class Service {

    public static Class klass = new Class();

    public static void addStudent(String studentInformation) {
        if (!ParseUtil.judgeStudentInputFormat(studentInformation)) {
            Scanner sc = new Scanner(System.in);
            addStudent(sc.next());

        } else {
            Student student = ParseUtil.extractStudentInformation(studentInformation);
            klass.addStudent(student);

            String addStudentPromptionInformation = "学生" + student.getName() + "的成绩被添加\n";
            System.out.println(addStudentPromptionInformation);

        }

    }
//
//    public static void printStudentScoreList(String inputStudentIds) {
//        if (!ParseUtil.judgeStudentInputIdsFormat(inputStudentIds)) {
//            System.out.println(Constant.PrintStudentScorePromptInformationWhenInputErr);
//            Scanner sc = new Scanner(System.in);
//            printStudentScoreList(sc.next());
//        } else {
//            ArrayList<String> studentIds = ParseUtil.extractStudentIds(inputStudentIds);
//
//            Report report = new Report(klass);
//            System.out.println(report.generateScoreList(studentIds));
//        }
//    }
}
