import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Assert;
import org.junit.Test;

public class MP1Test {

    @Test
    public void testSimpleCount() throws Exception {
        MP1 mp1 = new MP1("giovanni.gatti.pinheiro@gmail.com", "./test/resources/simple-input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(5));
        Assert.assertEquals(ret[0], is("word1"));
        Assert.assertEquals(ret[1], is("word2"));
        Assert.assertEquals(ret[2], is("word3"));
        Assert.assertEquals(ret[3], is("word4"));
        Assert.assertEquals(ret[4], is("word5"));
    }
}