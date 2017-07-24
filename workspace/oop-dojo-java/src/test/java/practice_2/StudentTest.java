package practice_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    public Student student;

    @Test
    public void getString() throws Exception {
        student = new Student("Tom", "21", 2);
        String resultString = "My name is Tom. I am 21 years old. I am a Student. I am at Class 2.\n";

        assertThat(student.introduce(), is(resultString));
    }
}
