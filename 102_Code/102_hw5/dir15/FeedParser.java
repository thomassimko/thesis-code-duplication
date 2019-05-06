import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


public class FeedParser 
	implements FeedReader 
{
	private ArrayList<String> sources;
	private ArrayList<String> badList;
	
	public FeedParser()
	{
		this.sources = new ArrayList<String>();
		this.badList = new ArrayList<String>();
	}

	@Override
	public void addSource(String src) 
	{
		sources.add(src);
	}

	@Override
	public List<String> getSources() 
	{
		return sources;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() 
	{
		int size=sources.size();
		ArrayList<RSSItem> rssList = new ArrayList<RSSItem>();
		badList.clear();
		
		for(int i = 0; i<size; i++)
		{
			try 
			{	
				sourceConvert(rssList, sources.get(i));
			}
			catch (Exception e) 
			{
				badList.add(sources.get(i));
			}
			
		}
		return rssList;
	}

	private void sourceConvert(List<RSSItem> rssList, String source) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, ParseException 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();
		Document feedDocument = builder.parse(source);
		XPathFactory xpfactory = XPathFactory.newInstance(); 
		XPath xpath = xpfactory.newXPath();
		String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument); 
		int itemCount = Integer.parseInt(countStr);
		
		for(int i = 1; i<=itemCount; i++)
		{
			String title = xpath.evaluate("/rss/channel/item["+ i +"]/title", feedDocument); 
			String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument); 
			String dateStr = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);
			
			DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z"); 
			Date d = df.parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			Date date = d;
			
			rssList.add(new RSS(title, date, link));
            Collections.sort(rssList, new DateComparator());
		}
	}

	@Override
	public List<String> getBadSources() 
	{
		return badList;
	}

	@Override
	public void removeBadSources() 
	{
		sources.removeAll(badList);
		badList.clear();
	}

}
