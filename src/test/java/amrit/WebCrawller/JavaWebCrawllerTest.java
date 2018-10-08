package amrit.WebCrawller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.regex.Pattern;


public class JavaWebCrawllerTest {

	JavaWebCrawller webCrawller;
	@Test
	  public void testExceptionIsThrown() {

		JavaWebCrawller webCrawller = new JavaWebCrawller();
		webCrawller.getPageLinks("gyhg", 2);
	  }

	@Test
	public void testExceptionifDepthLessthan1() {
		String url="http://www.bbc.com/";
		int depth=0;
		Assert.fail("depth less than 1");

	}

	@Test
	public void testExceptionIfwebCrawllerIsNull() {
    String url="http://www.bbc.com/";
     int depth=2;
			Assert.assertTrue(null==webCrawller);

	}

	@Test
	public void testExceptionIfURLisCorrect() {
		String url="http://www.bbc.com/";
		int depth=2;
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

		Assert.assertTrue( Pattern.matches(regex, url));

	}
}
