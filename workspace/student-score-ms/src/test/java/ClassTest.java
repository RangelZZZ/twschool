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

}
