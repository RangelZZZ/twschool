package core;

import core.Student;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {
    @Test
    public void should_calculate_student_average_score_and_total_score_when_the_student_count_is_even_count() throws Exception {
        Student student = new Student("guoru", "001", 94, 96, 92, 90);

        assertThat(student.getTotalScore(), is(372));
        assertThat(student.getAverageScore(), is(93));
    }
}
