package practice_10;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TeacherTest {
    private Teacher teacher;

    @Test
    public void should_get_teacher_information_when_teacher_teach_class() throws Exception {
        teacher = new Teacher("Tom", 21, 1, new Class(2));
        assertThat(teacher.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));
    }

    @Test
    public void should_get_teacher_information_when_teach_no_class() throws Exception {
        teacher = new Teacher("Tom", 21, 1);
        assertThat(teacher.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

}