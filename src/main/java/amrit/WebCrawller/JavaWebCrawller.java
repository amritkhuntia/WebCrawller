package amrit.WebCrawller;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaWebCrawller {

    public JavaWebCrawller() {
        links = new HashSet<String>();
    }
	private static final int MAXDEPTH = 2;
    private HashSet<String> links;

    
    public static void main(String[] args) {
        new JavaWebCrawller().getPageLinks("http://www.bbc.com/", 0);
    }



    public void getPageLinks(String URL, int depth) {
    	//int depth=0;
        if ((!links.contains(URL) && (depth < MAXDEPTH))) {
            System.out.println( " [" + URL + "]");
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("a[href]");
                Elements contentOnPage = document.select("meta[property^=og:]");
                for (int i = 0; i < contentOnPage.size(); i++) {
                    Element tag = contentOnPage.get(i);

                    String text = tag.attr("property");
                   if ("og:description".equals(text)) {
                       System.out.println(tag.attr("content"));
                    } else if ("og:title".equals(text)) {
                        System.out.println(tag.attr("content"));
                    }
                }        
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
