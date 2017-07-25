package practice_10;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Test
    public void should_return_leader_of_class_information() throws Exception {
        Class klass = new Class(2);

        student = new Student("Tom", 21, 1, klass);
        klass.appendMember(student);
        klass.assignLeader(student);

        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2."));
    }

    @Test
    public void should_return_student_information_when_student_is_not_leader() throws Exception {
        Class klass = new Class(2);

        student = new Student("Tom", 21, 1, klass);
        klass.appendMember(new Student("rangel", 21, 2, klass));
        klass.assignLeader(new Student("rangel", 21, 2, klass));

        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void should_return_warning_information_when_student_not_join_class() throws Exception {
        Class klass = new Class(2);
        klass.assignLeader(new Student("rangel", 21, 2, klass));

        assertThat(klass.judgeLeader(), is("It is not one of us."));
    }


}