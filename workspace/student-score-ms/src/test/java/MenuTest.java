import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


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
    public void out() {
        outContent.reset();
        Menu.main();
        assertEquals("hello world", outContent.toString().trim());
    }

    @Test
    public void should_return_false_when_student_input_err_information() throws Exception {
        String studentInput = "rangel,001";

        Boolean result = Menu.judgeStudentInputFormat(studentInput);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_student_input_right_information() throws Exception {
        String studentInput = "guoru，001，数学：97，语文：95，英语：76，编程：100";

        Boolean result = Menu.judgeStudentInputFormat(studentInput);

        assertThat(result, is(true));
    }

    @Test
    public void should_extract__student_data_when_student_input_right_information() throws Exception {
        String studentInput = "guoru，001，数学：97，语文：95，英语：76，编程：100";

        Student student = Menu.saveStudentInformation(studentInput);
        System.out.println(student.getName());

        assertThat(student.getName(),is("guoru"));
        assertThat(student.getId(), is("001"));
        assertThat(student.getMathScore(), is(97));
        assertThat(student.getChineseScore(), is(95));
        assertThat(student.getEnglishScore(), is(76));
        assertThat(student.getProgramScore(), is(100));
    }
}