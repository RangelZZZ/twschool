package practice_10;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Test
    public void should_return_person_information() throws Exception {
        person = new Person("Tom", 21,1);

        String resultString = "My name is Tom. I am 21 years old.";
        assertThat(person.introduce(), is(resultString));
    }
}


