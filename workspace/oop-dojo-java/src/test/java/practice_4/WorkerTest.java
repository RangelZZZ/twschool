package practice_4;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WorkerTest {
    private Worker worker;

    @Test
    public void getWorkInfo() throws Exception {
        worker = new Worker("Tom", 21);

        assertThat(worker.introduce(), is("My name is Tom. I am 21 years old. I am a Worker. I have a job."));
    }
}