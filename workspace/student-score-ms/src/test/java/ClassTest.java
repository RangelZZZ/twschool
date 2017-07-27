import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClassTest {

    @Test
    public void should_add_student_to_a_class() throws Exception {
        Student student = new Student("guoru", "001", 98, 95, 93, 100);

        ArrayList studentList = new Class().addStudent(student);
        Student stu = (Student) studentList.get(0);

        assertThat(stu.getId(), is("001"));
        assertThat(stu.getName(), is("guoru"));
        assertThat(stu.getMathScore(), is(98));
        assertThat(stu.getChineseScore(), is(95));
        assertThat(stu.getProgramScore(), is(100));
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
}
