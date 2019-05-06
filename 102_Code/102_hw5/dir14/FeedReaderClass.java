import java.text.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class FeedReaderClass 
   implements FeedReader 
{
	private List<String> sources = new ArrayList<String>();
	private List<String> badSources = new ArrayList<String>();
	
	public void addSource(String src) 
	{
		sources.add(src);
	}

	public List<String> getSources() 
	{
		return sources;
	}

	public List<RSSItem> retrieveFeedItems()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		
		List<RSSItem> feedItemsList = new ArrayList<RSSItem>();

		badSources = new ArrayList<String>();
		for(String src : sources)
		{
			try
			{
				builder = factory.newDocumentBuilder();
				document = builder.parse(src);
				XPathFactory xpfactory = XPathFactory.newInstance();
				XPath xpath = xpfactory.newXPath();
				String strCount = xpath.evaluate("count(/rss/channel/item)", document);
				int count = Integer.parseInt(strCount);
			
				for(int i = 1; i < count; i++)
				{
					String title = xpath.evaluate("/rss/channel/item["+i+"]/title", document);
					String link = xpath.evaluate("/rss/channel/item["+i+"]/link", document);
					String sourceDate = xpath.evaluate("/rss/channel/item["+i+"]/pubDate", document);
					Date date = parseDate(sourceDate);
					
					RSSItem feedItems = new RSSItemClass(title, link, date);
					feedItemsList.add(feedItems);
				}
			}
			catch(ParseException e)
			{
				addBadSource(src);
			}
			catch(Exception e1)
			{
				addBadSource(src);
			}
		}		
		return feedItemsList;
	}
	
	public Date parseDate(String date)
		throws ParseException
	{
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Date d = df.parse(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return d;
	}
	
	public void addBadSource(String src)
	{
		badSources.add(src);
	}

	public List<String> getBadSources()
	{
		return badSources;
	}

	public void removeBadSources() 
	{
		for(String src : badSources)
		{
			sources.remove(src);
		}
		badSources = new ArrayList<String>();
	}
}
