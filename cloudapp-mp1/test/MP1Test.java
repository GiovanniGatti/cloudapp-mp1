import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Assert;
import org.junit.Test;

public class MP1Test {

    private String username = "1008698";

    @Test
    public void testSimpleCount() throws Exception {
        MP1 mp1 = new MP1(username, "./test/resources/simple-input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("word1"));
        Assert.assertThat(ret[1], is("word2"));
        Assert.assertThat(ret[2], is("word3"));
        Assert.assertThat(ret[3], is("word4"));
        Assert.assertThat(ret[4], is("word5"));
    }

    @Test
    public void testCountWithDelimiters() throws Exception {
        MP1 mp1 = new MP1(username, "./test/resources/delimiters-input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("word1"));
        Assert.assertThat(ret[1], is("word2"));
        Assert.assertThat(ret[2], is("word3"));
        Assert.assertThat(ret[3], is("word4"));
        Assert.assertThat(ret[4], is("word5"));
    }

    @Test
    public void testCountWithCommonWords() throws Exception {
        MP1 mp1 = new MP1(username, "./test/resources/common-words-input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("word1"));
        Assert.assertThat(ret[1], is("word2"));
        Assert.assertThat(ret[2], is("word3"));
        Assert.assertThat(ret[3], is("word4"));
        Assert.assertThat(ret[4], is("word5"));
    }

    public void testIgnoreUppercaseWords() throws Exception {
        MP1 mp1 = new MP1(username, "./test/resources/uppercase-input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("word1"));
        Assert.assertThat(ret[1], is("word2"));
        Assert.assertThat(ret[2], is("word3"));
        Assert.assertThat(ret[3], is("word4"));
        Assert.assertThat(ret[4], is("word5"));
    }

    @Test
    public void testCourseraInput() throws Exception {
        MP1 mp1 = new MP1("1", "./src/input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        for (String item : ret) {
            System.out.println(item);
        }
    }
}