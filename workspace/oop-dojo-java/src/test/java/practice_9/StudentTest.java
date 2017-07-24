package practice_9;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Test
    public void should_return_student_information() throws Exception {
        student = new Student("Tom", 21, new Class(2));
        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }
}