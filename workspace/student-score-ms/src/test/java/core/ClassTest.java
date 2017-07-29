package core;


import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClassTest {

    @Test
    public void should_add_student_to_a_class() throws Exception {
        Student student = new Student("guoru", "001", 98, 95, 93, 100);
        ArrayList studentList = (ArrayList) new Class().addStudent(student);

        assertThat(studentList.size(), is(1));
    }

    @Test
    public void should_calculate_all_students_total_score_and_median_score_when_student_score_is_even_count() throws Exception {

        ArrayList<Student> selectedStudent = new ArrayList<>();
        selectedStudent.add(new Student("guoru", "001", 94, 96, 92, 90));
        selectedStudent.add(new Student("fuhong", "002", 100, 98, 92, 98));

        assertThat(new Class().getTotalScore(selectedStudent), is(760));
        assertThat(new Class().getMedianScore(selectedStudent), is(380));

    }


    @Test
    public void should_calculate_all_students_total_score_and_median_score_when_student_count_is_odd_count() throws Exception {
        Class klass = new Class();
        ArrayList<Student> selectedStudent = new ArrayList<>();
        selectedStudent.add(new Student("guoru", "001", 94, 96, 92, 90));
        selectedStudent.add(new Student("fuhong", "002", 100, 98, 90, 98));
        selectedStudent.add(new Student("rangel", "003", 100, 96, 98, 100));

        assertThat(klass.getTotalScore(selectedStudent), is(1152));
        assertThat(klass.getMedianScore(selectedStudent), is(386));
    }

}
