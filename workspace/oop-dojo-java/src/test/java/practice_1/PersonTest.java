package practice_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    private Person person;

    @Test
    public void getString() throws Exception {
        person = new Person("Tom", "21");

        String resultString = "My name is Tom. I am 21 years old.\n";
        assertThat(person.introduce(), is(resultString));
    }
}