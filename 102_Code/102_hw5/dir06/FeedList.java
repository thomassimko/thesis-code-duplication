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




public class FeedList implements FeedReader 
{
	private List<RSSItem> feedList;
	private List<String> badSources;
	private List<String> sources;
	
	public FeedList()
	{
		feedList = new LinkedList<RSSItem>();
		badSources = new LinkedList<String>();
		sources = new LinkedList<String>();
	}


	public void addSource(String src) 
	{
		if (sources.contains(src) == false)
		{
			sources.add(src);
		}
	}
	
	private int itemCounter(Document feedDocument) throws XPathExpressionException
	{
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
		int itemCount = Integer.parseInt(countStr);
		return itemCount;
	}
	
	public List<String> getSources() 
	{
		return sources;
	}

	public List<RSSItem> retrieveFeedItems() 
	{
		feedList = retrieveFeedItemsHelper();
		return feedList;
	}
	
	private List<RSSItem> retrieveFeedItemsHelper()
	{
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		List<RSSItem> newList = new LinkedList<RSSItem>();
		for (int i = 0; i<sources.size(); i++)
		{
			try
			{
				Document feedDocument = getDocument(sources.get(i));
				int itemCount = itemCounter(feedDocument);
				for (int k = 1; k < itemCount + 1; k++)
				{
					String title = xpath.evaluate("/rss/channel/item["+ k +"]/title", feedDocument);
					String link = xpath.evaluate("/rss/channel/item["+ k +"]/link", feedDocument);
					String date = xpath.evaluate("/rss/channel/item["+ k +"]/pubDate", feedDocument);
					Calendar calDate = convertDate(date);
					newList.add(new Item(title, calDate, link));
				}
			}
			catch (IOException e)
			{
				if (badSources.contains(sources.get(i)) == false)
				{
					badSources.add(sources.get(i));
				}
			}
			catch (SAXException p)
			{
				if (badSources.contains(sources.get(i)) == false)
				{
					badSources.add(sources.get(i));
				}
			}
			catch (XPathExpressionException k)
			{
				if (badSources.contains(sources.get(i)) == false)
				{
					badSources.add(sources.get(i));
				}
			}
			catch (ParseException e)
			{
				if (badSources.contains(sources.get(i)) == false)
				{
					badSources.add(sources.get(i));
				}
			}
		}
		return newList;
	}
	
	private Calendar convertDate(String date) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Date d = df.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	private Document getDocument(String src) throws IOException, SAXException
	{
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document feedDocument = builder.parse(src);
			return feedDocument;
		}
		catch (ParserConfigurationException e)
		{
			System.out.println("Document parser error");
			return null;
		}
	}

	public List<String> getBadSources() 
	{
		return badSources;
	}

	public void removeBadSources() 
	{
		for (int i = 0; i < badSources.size(); i++)
		{
			for (int k = sources.size() - 1; k > -1; k --)
			{
				if (badSources.get(i).equals(sources.get(k)))
				{
					sources.remove(k);
				}
			}
		}
		badSources.clear();
	}

}
