import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class ClassTest {

    @Test
    public void should_add_student_to_a_class() throws Exception {
        Student student = new Student("guoru", "001", 98, 95, 93, 100);
        ArrayList studentList = new Class().addStudent(student);

        assertThat(studentList.size(), is(1));
    }

    @Test
    public void should_calculate_all_students_total_score_and_median_score_when_student_score_is_even_count() throws Exception {
        Class klass = new Class();
        klass.addStudent(new Student("guoru", "001", 94, 96, 92, 90));
        klass.addStudent(new Student("fuhong", "002", 100, 98, 92, 98));

        assertThat(klass.getTotalScore(), is(760));
        assertThat(klass.getMedianScore(), is(380));

    }


    @Test
    public void should_calculate_all_students_total_score_and_median_score_when_student_count_is_odd_count() throws Exception {
        Class klass = new Class();
        klass.addStudent(new Student("guoru", "001", 94, 96, 92, 90));
        klass.addStudent(new Student("fuhong", "002", 100, 98, 90, 98));
        klass.addStudent(new Student("rangel", "003", 100, 96, 98, 100));

        assertThat(klass.getTotalScore(), is(1152));
        assertThat(klass.getMedianScore(), is(386));
    }


    @Test
    public void should_get_selected_student_score() throws Exception {
        ArrayList<String> studentIds = new ArrayList<String>();
        studentIds.add("001");
        studentIds.add("002");

        Class klass = new Class();
        Student student1 = new Student("guoru", "001", 94, 96, 92, 90);
        Student student2 = new Student("fuhong", "002", 100, 98, 90, 98);
        Student student3 = new Student("rangel", "003", 100, 96, 98, 100);
        klass.addStudent(student1);
        klass.addStudent(student2);
        klass.addStudent(student3);

        ArrayList<Student> selectedStudents = new ArrayList<>();
        selectedStudents.add(student1);
        selectedStudents.add(student2);

        ArrayList<Student> selectedStudent = (ArrayList<Student>) klass.getSelectedStudent(studentIds);
        assertThat(selectedStudent, is(selectedStudents));
    }
}
