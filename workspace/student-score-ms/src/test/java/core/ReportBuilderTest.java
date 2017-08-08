package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportBuilderTest {

    @Test
    public void should_calculate_all_student_total_score_and_median_score() throws Exception {

        List<Student> studentList = new ArrayList<Student>();
        Student student1 = new Student("guoru", "001", 100, 100, 100, 100);
        Student student2 = new Student("guoru", "002", 100, 100, 100, 100);
        studentList.add(student1);
        studentList.add(student2);

        Report reportBuilder = new Report(studentList);

        assertThat(reportBuilder.getTotalScore(), is(800));
        assertThat(reportBuilder.getMedianScore(), is(400));
    }
}