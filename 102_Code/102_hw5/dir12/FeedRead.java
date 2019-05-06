import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class FeedRead implements FeedReader {
	
	private List<String> sources = new ArrayList<String>();
	private List<RSSItem> items = new ArrayList<RSSItem>();
	private List<String> badSrc = new ArrayList<String>();
	
	public void addSource(String src) {
		sources.add(src);
		try {
			items = makeItem(retrieve(src));
		} catch (SAXException e) {
			badSrc.add(src);
			System.out.println("Invalid source");
		} catch (IOException e) {
			badSrc.add(src);
			System.out.println("Invalid source");
		} catch (ParserConfigurationException e) {
			badSrc.add(src);
			System.out.println("Invalid source");
		} catch (XPathExpressionException e) {
			badSrc.add(src);
			System.out.println("Invalid source");
		} catch (ParseException e) {
			badSrc.add(src);
			System.out.println("Invalid source");
		}
		
	}

	public List<String> getSources() {
		return sources;
	}

	public List<RSSItem> retrieveFeedItems() {
		
		return items;
	}

	public List<String> getBadSources() {

		return badSrc;
	}

	public void removeBadSources() {
		
		for(int i=0;i<sources.size();i++){
			for(int j=0;j<badSrc.size();j++){
				if(sources.get(i).equals(badSrc.get(j))){
					sources.remove(i);
				}
			}
		}	
	}
	
	private static Document retrieve(String str) throws SAXException, IOException, ParserConfigurationException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document feedDocument = null;

		builder = factory.newDocumentBuilder();
		feedDocument = builder.parse(str);
		
		return feedDocument;
	}
	
	private static List<RSSItem> makeItem(Document givenDocument) throws XPathExpressionException, ParseException{
		SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		String countStr = null;
		Calendar c = Calendar.getInstance();
		Date time = null;
		List<RSSItem> list = new ArrayList<RSSItem>();
		String title = null;
		String link = null;
		String date = null;
		countStr = xpath.evaluate("count(/rss/channel/item)", givenDocument);		
		
		for(int j = 1;j<=Integer.parseInt(countStr);j++){

			title = xpath.evaluate("/rss/channel/item["+j+"]/title", givenDocument);
			link = xpath.evaluate("/rss/channel/item["+j+"]/link", givenDocument);
			date = xpath.evaluate("/rss/channel/item["+j+"]/pubDate", givenDocument);
			time = df.parse(date);
			
			c.setTime(time);
			
			list.add(new StoredRSS(title, c, link));
		}
		
		
		
		return 	list;
	}
}
