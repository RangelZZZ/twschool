import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class MenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void should_return_false_when_student_input_err_information() throws Exception {
        String studentInput = "rangel,001";

        Boolean result = Menu.judgeStudentInputFormat(studentInput);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_student_input_right_information_format() throws Exception {
        String studentInput = "guoru，001，数学：97，语文：95，英语：76，编程：100";

        Boolean result = Menu.judgeStudentInputFormat(studentInput);

        assertThat(result, is(true));
    }

    @Test
    public void should_extract__student_data_when_student_input_right_information() throws Exception {
        String studentInput = "guoru，001，数学：97，语文：95，英语：76，编程：100";

        Student student = Menu.extractStudentInformation(studentInput);

        assertThat(student.getName(), is("guoru"));
        assertThat(student.getId(), is("001"));
        assertThat(student.getMathScore(), is(97));
        assertThat(student.getChineseScore(), is(95));
        assertThat(student.getEnglishScore(), is(76));
        assertThat(student.getProgramScore(), is(100));
    }

    @Test
    public void should_return_false_when_input_err_student_id() throws Exception {
        String inputStudentIds = "001，002，003";

        Boolean result = Menu.judgeStudentInputIdsFormat(inputStudentIds);

        assertThat(result, is(true));
    }

    @Test
    public void should_extract_student_ids_when_input_right_ids_() throws Exception {
        String inputStudentIds = "001，002，003";

        ArrayList<String> studentIds = new ArrayList<String>();
        studentIds.add("001");
        studentIds.add("002");
        studentIds.add("003");

        assertThat(Menu.extractStudentIds(inputStudentIds), is(studentIds));
    }
}