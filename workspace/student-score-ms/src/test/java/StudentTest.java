import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {
    @Test
    public void should_calculate_student_average_score_and_total_score() throws Exception {
        Student student = new Student("guoru", "001", 94, 96, 92, 90);

        assertThat(student.getTotalScore(), is(372));
        assertThat(student.getAverageScore(), is(93));
    }
}