package core;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportItemTest {
    @Test
    public void should_get_student_totalScore_and_average_score() throws Exception {
        Grade student = new Grade("guoru", "001", 100, 100, 100, 100);

        assertThat(new ReportItem(student).getTotalScore(), is(400));
        assertThat(new ReportItem(student).getAverageScore(), is(100));
    }
}
