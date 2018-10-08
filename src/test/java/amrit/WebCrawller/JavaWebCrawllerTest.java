package amrit.WebCrawller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;


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
}
