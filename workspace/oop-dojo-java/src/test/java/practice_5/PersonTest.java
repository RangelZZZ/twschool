package practice_5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Test
    public void getpersonInfo() throws Exception {
        person = new Person("Tom", 21);
        assertThat(person.introduce(), is("My name is Tom. I am 21 years old."));
    }
}