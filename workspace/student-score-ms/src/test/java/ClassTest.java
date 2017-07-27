import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClassTest {

    @Test
    public void name() throws Exception {
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
    public void should_calculate_all_students_total_score_and_median_score() throws Exception {
        Class klass = new Class();

        klass.addStudent(new Student("guoru", "001", 94, 96, 92, 90));
        klass.addStudent(new Student("fuhong", "002", 100, 98, 90, 98));


        assertThat(klass.getTotalScore(),is(758));
        assertThat(klass.getMedianScore(), is(379));

    }
}
