<<<<<<< HEAD
import org.junit.Assert;
import org.junit.Test;

public class MP1Test {

    @Test
    public void testSimpleCount() throws Exception {
        MP1 mp1 = new MP1("giovanni.gatti.pinheiro@gmail.com", "./test/resources/simple-input.txt");
        String[] ret = mp1.process();

        Assert.assertNotNull(ret);
        Assert.assertTrue(ret.length == 5);
        Assert.assertEquals("word1", ret[0]);
        Assert.assertEquals("word2", ret[1]);
        Assert.assertEquals("word3", ret[2]);
        Assert.assertEquals("word4", ret[3]);
        Assert.assertEquals("word5", ret[4]);
    }

}
=======
import org.junit.Assert;
import org.junit.Test;

public class MP1Test {

	@Test
	public void testSimpleCount() throws Exception {
		MP1 mp1 = new MP1("giovanni.gatti.pinheiro@gmail.com", "./test/resources/simple-input.txt");
		String[] ret = mp1.process();

		Assert.assertNotNull(ret);
		Assert.assertTrue(ret.length == 5);
		Assert.assertEquals("word1", ret[0]);
		Assert.assertEquals("word2", ret[1]);
		Assert.assertEquals("word3", ret[2]);
		Assert.assertEquals("word4", ret[3]);
		Assert.assertEquals("word5", ret[4]);
	}

}
>>>>>>> branch 'master' of https://github.com/GiovanniGatti/cloudapp-mp1.git
