import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Assert;
import org.junit.Test;

public class MP1Test {

    @Test
    public void testSimpleCount() throws Exception {
        MP1 mp1 = new MP1(null, "./test/resources/simple-input.txt");
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
        MP1 mp1 = new MP1(null, "./test/resources/delimiters-input.txt");
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
        MP1 mp1 = new MP1(null, "./test/resources/common-words-input.txt");
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
        MP1 mp1 = new MP1(null, "./test/resources/uppercase-input.txt");
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
    public void testCourseraInput_0() throws Exception {
        MP1 mp1 = new MP1("0", "./src/input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("list"));
        Assert.assertThat(ret[1], is("de"));
        Assert.assertThat(ret[2], is("state"));
        Assert.assertThat(ret[3], is("school"));
        Assert.assertThat(ret[4], is("disambiguation"));
        Assert.assertThat(ret[5], is("county"));
        Assert.assertThat(ret[6], is("new"));
        Assert.assertThat(ret[7], is("john"));
        Assert.assertThat(ret[8], is("album"));
        Assert.assertThat(ret[9], is("c"));
        Assert.assertThat(ret[10], is("river"));
        Assert.assertThat(ret[11], is("station"));
        Assert.assertThat(ret[12], is("united"));
        Assert.assertThat(ret[13], is("highway"));
        Assert.assertThat(ret[14], is("national"));
        Assert.assertThat(ret[15], is("saint"));
        Assert.assertThat(ret[16], is("william"));
        Assert.assertThat(ret[17], is("route"));
        Assert.assertThat(ret[18], is("f"));
        Assert.assertThat(ret[19], is("film"));
    }

    @Test
    public void testCourseraInput_1() throws Exception {
        MP1 mp1 = new MP1("1", "./src/input.txt");
        String[] ret = mp1.process();

        Assert.assertThat(ret, is(not(nullValue())));
        Assert.assertThat(ret.length, is(MP1.OUTPUT_LIMIT));
        Assert.assertThat(ret[0], is("list"));
        Assert.assertThat(ret[1], is("de"));
        Assert.assertThat(ret[2], is("state"));
        Assert.assertThat(ret[3], is("school"));
        Assert.assertThat(ret[4], is("disambiguation"));
        Assert.assertThat(ret[5], is("county"));
        Assert.assertThat(ret[6], is("new"));
        Assert.assertThat(ret[7], is("john"));
        Assert.assertThat(ret[8], is("river"));
        Assert.assertThat(ret[9], is("route"));
        Assert.assertThat(ret[10], is("film"));
        Assert.assertThat(ret[11], is("album"));
        Assert.assertThat(ret[12], is("c"));
        Assert.assertThat(ret[13], is("high"));
        Assert.assertThat(ret[14], is("united"));
        Assert.assertThat(ret[15], is("william"));
        Assert.assertThat(ret[16], is("st"));
        Assert.assertThat(ret[17], is("national"));
        Assert.assertThat(ret[18], is("football"));
        Assert.assertThat(ret[19], is("saint"));
    }
}