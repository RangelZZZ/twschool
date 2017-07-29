package interator_layer;

import core.Class;
import core.Student;
import shell.Menu;
import util.Constant;
import util.ParseUtil;

import java.util.Scanner;

public class Service {

    public static void addStudent(String studentInformation) {
        if (!ParseUtil.judgeStudentInputFormat(studentInformation)) {
            System.out.println(Constant.AddStudentPromptInformationWhenInputErr);
            Scanner sc = new Scanner(System.in);
            addStudent(sc.next());

        } else {
            Student student = ParseUtil.extractStudentInformation(studentInformation);
            new Class().addStudent(student);

            String addStudentPromptionInformation = "学生" + student.getName() + "的成绩被添加\n";
            System.out.println(addStudentPromptionInformation);

            new Menu().disPlayMenu();
        }

    }

    public static void printStudentScoreList(String next) {
    }
}
