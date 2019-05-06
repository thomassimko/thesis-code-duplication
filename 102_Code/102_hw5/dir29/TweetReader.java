import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class TweetReader implements FeedReader {
	List<String> sourceList = new ArrayList<String>();
	List<String> badSourceList = new ArrayList<String>();
	@Override
	public void addSource(String src) {
		sourceList.add(src);
	}

	@Override
	public List<String> getSources() {
		Collections.sort(sourceList);
		return sourceList;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() {
		List<RSSItem> tweetList = new ArrayList<RSSItem>();
		try{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		for(String source : sourceList){
			try{
			Document feedDocument = builder.parse(source);
			XPathFactory xpfactory = XPathFactory.newInstance();
			XPath xpath = xpfactory.newXPath();
			String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
			int itemCount = Integer.parseInt(countStr);
			for(int i = 1; i <= itemCount; i++ ){
				String title = xpath.evaluate("/rss/channel/item["+i+"]/title", feedDocument);
				String link = xpath.evaluate("/rss/channel/item["+i+"]/link", feedDocument);
				String dateStr = xpath.evaluate("rss/channel/item["+i+"]/pubDate", feedDocument);
				SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
				Date date  = (Date)formatter.parse(dateStr); 
				Calendar cal=Calendar.getInstance();
				cal.setTime(date);
				RSSItem tweet = new Tweet(title,cal,link);
				tweetList.add(tweet);
			}
			}catch(ParseException|XPathExpressionException|IOException|SAXException e){
				badSourceList.add(source);
			}
		}
		}catch(ParserConfigurationException e){
			
		}
		Collections.sort(tweetList, new RSSItemComparator());
		return tweetList;
	}

	@Override
	public List<String> getBadSources() {
		return badSourceList;
	}

	@Override
	public void removeBadSources() {
		for(String badSource : badSourceList){
			for(int i = 0; i < sourceList.size(); i++){
				if(badSource.equals(sourceList.get(i))){
					sourceList.remove(i);
				}
			}
		}
		badSourceList = new ArrayList<String>();
	}

}
