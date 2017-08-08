package core;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

//public class ReportTest {

//    @Test
//    public void should_generate_score_list_() throws Exception {
//
//        ArrayList<Student> students = new ArrayList<Student>();
//        Student student1 = new Student("guoru", "001", 94, 96, 92, 90);
//        Student student2 = new Student("fuhong", "002", 100, 98, 92, 98);
//        students.add(student1);
//        students.add(student2);
//
//        Class klass = new Class();
//        klass.addStudent(student1);
//        klass.addStudent(student2);
//
//        ArrayList<String> studentIds = new ArrayList<>();
//        studentIds.add("001");
//        studentIds.add("002");
//
//        String studentScoreList = new Report(klass).generateScoreList(studentIds);
//
//        System.out.println(studentScoreList);
//        assertThat(studentScoreList, is("成绩单\n" +
//                "姓名|数学|语文|英语|编程|平均分|总分\n" +
//                "========================\n" +
//                "guoru|94|96|92|90|93|372\n" +
//                "fuhong|100|98|92|98|97|388\n" +
//                "========================\n" +
//                "全班总平均分：760\n" +
//                "全班总分中位数：380\n"));
//
//    }
//}
