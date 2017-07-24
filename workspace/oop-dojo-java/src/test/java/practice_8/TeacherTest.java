package practice_8;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TeacherTest {
    private Teacher teacher;
    private Student student;

    @Test
    public void getTeacherInfoWhenHaveClass() throws Exception {
        teacher = new Teacher("Tom", 21, new Class(2));
        assertThat(teacher.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));
    }

    @Test
    public void getTeacherInfoWhenNoClass() throws Exception {
        teacher = new Teacher("Tom", 21);
        assertThat(teacher.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

    @Test
    public void should_print_teacher_teach_student_message() throws Exception {
        teacher = new Teacher("Tom", 21, new Class(2));

        assertThat(teacher.introduceWith(new Student("Jerry", 21, new Class(2))), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry."));
    }

    @Test
    public void should_print_teacher_not_teach_student_message() throws Exception {
        teacher = new Teacher("Tom", 21, new Class(2));

        assertThat(teacher.introduceWith(new Student("Jerry", 21, new Class(1))), is("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry."));
    }
}