package amrit.WebCrawller;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaWebCrawller {
	private static final int MAXDEPTH = 2;
    private HashSet<String> links;
    
    public static void main(String[] args) {
        new JavaWebCrawller().getPageLinks("http://www.bbc.com/", 0);
    }

    public JavaWebCrawller() {
        links = new HashSet<String>();
    }

    public void getPageLinks(String URL, int depth) {
    	//int depth=0;
        if ((!links.contains(URL) && (depth < MAXDEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("a[href]");

                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

}
