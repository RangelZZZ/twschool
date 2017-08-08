package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportBuilderTest {

    @Test
    public void should_calculate_all_student_total_score_and_median_score() throws Exception {

        List<ReportItem> reportItemList = new ArrayList<ReportItem>();
        ReportItem reportItem1 = new ReportItem(new Student("guoru", "001", 100, 100, 100, 100));
        ReportItem reportItem2 = new ReportItem(new Student("guoru", "002", 100, 100, 100, 100));
        reportItemList.add(reportItem1);
        reportItemList.add(reportItem2);

        ReportBuilder reportBuilder = new ReportBuilder(reportItemList);

        assertThat(reportBuilder.getReportTotalScore(), is(800));
        assertThat(reportBuilder.getMedianScore(), is(400));
    }
}