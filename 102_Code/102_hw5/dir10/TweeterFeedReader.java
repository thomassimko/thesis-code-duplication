import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TweeterFeedReader implements FeedReader {
	private Document feedDocument;
	private List<RSSItem> itemList;
	private List<String> sourceList;
	private List<String> badSources;
	
	public TweeterFeedReader (){
		this.itemList = new LinkedList<RSSItem>();
		this.sourceList = new LinkedList<String>();
		this.badSources = new LinkedList<String>();
	}
	
	@Override
	public void addSource(String src) {
		sourceList.add(src);
		//System.out.println("Adding source: " + src);
		//System.out.println("SourceList.size is " + sourceList.size());
	}

	@Override
	public List<String> getSources() {
		List<String> stringSourceList = new LinkedList<String>();
		for (int i = 0; i < sourceList.size(); i++) {
			stringSourceList.add(sourceList.get(i));
		}
		return stringSourceList;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() {
		List<RSSItem> newRSSItemList = new LinkedList<RSSItem>();
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		for (int i = 0; i < sourceList.size(); i++) {
			String countStr;
			int itemCount;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				feedDocument = builder.parse(sourceList.get(i));
				countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				itemCount = Integer.parseInt(countStr);
				String title, link, date;
				//System.out.println("The itemCount is: " + itemCount);
				for (int j = 1; j < itemCount+1; j++) {
					title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
					link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
					date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
					//System.out.println("Title: " + title);
					//System.out.println("link: " + link);
					//System.out.println("date: " + date.toString());
					
					DateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z"); 
					Date d;
					try {
						d = df.parse(date);
						Calendar c = Calendar.getInstance();
						c.setTime(d);
						TweeterRSSItem newItem = new TweeterRSSItem (title, c, link);
						newRSSItemList.add(newItem);
						//System.out.println("Source was added to item list.");
					}
					catch (ParseException e) {
						badSources.add(sourceList.get(i));
						//System.out.println("Was added to badSourceList because of ParseException");
					}
					
				}
			}
			catch (ParserConfigurationException e) {
				badSources.add(sourceList.get(i));
				//System.out.println("Was added to badSourceList because of ParserConfigurationException");
			}
			catch (SAXException e) {
				badSources.add(sourceList.get(i));
				//System.out.println("Was added to badSourceList because of SAXException");
			} 
			catch (IOException e) {
				badSources.add(sourceList.get(i));
				//System.out.println("Was added to badSourceList because of IOException");
			}
			catch (XPathExpressionException e) {
				badSources.add(sourceList.get(i));
				//System.out.println("Was added to badSourceList because of XPathExpressionException");
			}
		}
		//System.out.println("Got to the getFeedItems function, must have not saved");
		return newRSSItemList;
	}
	
	public boolean getBadSourcesHelper (String curSrc, List<String> badSources, int curIndex) {
		for (int i = curIndex + 1; i < badSources.size(); i++) {
			if (curSrc.equals(badSources.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<String> getBadSources() {
		List<String> badSrcHelpList = new LinkedList<String>();
		for (int i = 0; i < badSources.size(); i++) {
			if (getBadSourcesHelper(badSources.get(i), badSources, i) == false) {
				badSrcHelpList.add(badSources.get(i));
			}
			//System.out.println(badSources.get(i));
		}
		badSources = badSrcHelpList;
		return badSources;
	}

	@Override
	public void removeBadSources() {
		for (int i = 0; i < sourceList.size(); i++) {
			for (int j = 0; j < badSources.size(); j++) {
				if (sourceList.get(i).equalsIgnoreCase(badSources.get(j))) {
					sourceList.remove(i);
				}
			}
		}
		badSources.clear();
	}

}
