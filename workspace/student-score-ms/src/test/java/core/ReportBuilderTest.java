package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportBuilderTest {

    @Test
    public void should_calculate_all_student_total_score_and_median_score() throws Exception {

        List<Grade> studentList = new ArrayList<Grade>();
        Grade student1 = new Grade("guoru", "001", 100, 100, 100, 100);
        Grade student2 = new Grade("guoru", "002", 100, 100, 100, 100);
        studentList.add(student1);
        studentList.add(student2);

        Report report = new Report();
        report.createItemList(studentList);

        assertThat(report.getTotalScore(), is(800));
        assertThat(report.getMedianScore(), is(400));
    }
}