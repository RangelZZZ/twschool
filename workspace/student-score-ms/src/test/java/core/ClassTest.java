package core;


import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClassTest {

    @Test
    public void should_add_student_to_a_class() throws Exception {
        Student student = new Student("guoru", "001", 98, 95, 93, 100);
        ArrayList studentList = (ArrayList) new Class().addStudent(student);

        assertThat(studentList.size(), is(1));
    }

    @Test
    public void should_choose_students_by_studentIds() throws Exception {
        Class klass = new Class();
        klass.addStudent(new Student("guoru", "001", 98, 95, 93, 100));
        klass.addStudent(new Student("jason", "002", 98, 95, 93, 100));
        klass.addStudent(new Student("fuhong", "003", 98, 95, 93, 100));

        ArrayList<String> studentListIds = new ArrayList<String>();
        studentListIds.add("001");
        studentListIds.add("002");

        assertThat(klass.selectStudents(studentListIds).size(), is(2));
    }
}
