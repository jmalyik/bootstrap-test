package foo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FooTest
{
    @Test
    public void foo()
    {
        assertThat(ClassLoader.getSystemClassLoader().getClass().getCanonicalName(),
                is(HackitClassLoader.class.getCanonicalName()));
    }
}
