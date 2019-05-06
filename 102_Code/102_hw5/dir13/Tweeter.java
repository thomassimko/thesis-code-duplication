import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Tweeter implements FeedReader {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	ArrayList<String> sources = new ArrayList<String>();
	ArrayList<String> badSources = new ArrayList<String>();
	XPathFactory xpfactory = XPathFactory.newInstance();
	XPath xpath = xpfactory.newXPath();
	int items;
	
	public Tweeter() {
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void addSource(String src) {
		sources.add(src);
	}

	public List<String> getSources() {
		return sources;
	}

	public List<RSSItem> retrieveFeedItems() {
		badSources = new ArrayList<String>();
		ArrayList<RSSItem> parsed = new ArrayList<RSSItem>();
		for (String url: sources) {
			Document feedDocument;
			try {
				feedDocument = builder.parse(url);
				try {
					items = Integer.parseInt(xpath.evaluate("count(/rss/channel/item)", feedDocument));
					if (feedDocument != null)
						for (int i = 1; i <= items; i++) {
							String title = null;
							String link = null;
							String date = null;
							Calendar c = new GregorianCalendar();
							boolean fail = false;

							try {
								title = xpath.evaluate("/rss/channel/item["+i+"]/title", feedDocument);
								try {
									link = xpath.evaluate("/rss/channel/item["+i+"]/link", feedDocument);
									try {
										date = xpath.evaluate("/rss/channel/item["+i+"]/pubDate", feedDocument);
										try {
											c.setTime((new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss Z")).parse(date));
										} catch (ParseException e) {
											badSources.add(url);
											fail = true;
										}
									} catch (XPathExpressionException e) {
										badSources.add(url);
										fail = true;
									} 
								} catch (XPathExpressionException e) {
									badSources.add(url);
									fail = true;
								} 
							} catch (XPathExpressionException e) {
								badSources.add(url);
								fail = true;
							} 

							if (fail == true) {
								System.err.println("bleh");
								break;
							}
							parsed.add(new RSSItemParser(title, link, c));
						}
				} catch (Exception e) {
					badSources.add(url);
				}
			} catch (Exception e) {
				badSources.add(url);
			}		
		}
		return parsed;
	}

	public List<String> getBadSources() {
		return badSources;
	}

	public void removeBadSources() {
		for (int i = 0; i < sources.size(); i++)
			for (int n = 0; n < badSources.size(); n++) {
				if (sources.get(i).equals(badSources.get(n))) {
					sources.remove(i);
					badSources.remove(n);
				}
				
			}
	}

}

class test {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Tweeter a = new Tweeter();
		a.addSource("http://search.twitter.com/search.rss?q=ActuallyNPH");
		System.out.println(a.retrieveFeedItems());
	}
}