import java.text.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;

public class TwitterFeedReader
	implements FeedReader
{
	private static final DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

	private List<String> sources;
	private List<String> badSources;

	public TwitterFeedReader()
	{
		this.sources = new ArrayList<String>();
	}

	public void addSource(String src)
	{
		sources.add(src);
	}

	public List<String> getSources()
	{
		Collections.sort(this.sources, String.CASE_INSENSITIVE_ORDER);

		return sources;
	}

	public List<RSSItem> retrieveFeedItems()
	{
		List<RSSItem> feedItems = new ArrayList<RSSItem>();
		List<String> newBadSources = new ArrayList<String>();

		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			XPathFactory xpfactory = XPathFactory.newInstance();
			XPath xpath = xpfactory.newXPath();

			for(String src : sources)
			{
				try
				{
					Document feedDocument = builder.parse(src);

					String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
					int itemCount = Integer.parseInt(countStr);

					readTweets(feedDocument, itemCount, feedItems, xpath);
				}
				catch(Exception e)
				{
					newBadSources.add(src);
				}
			}

			Collections.sort(feedItems, new RSSItemDateComparator());
		}
		catch(ParserConfigurationException e)
		{
		}

		this.badSources = newBadSources;

		return feedItems;
	}

	private static void readTweets(Document feedDocument, int itemCount, List<RSSItem> feedItems, XPath xpath)
		throws ParseException, XPathExpressionException
	{
		for(int i=1; i<=itemCount; i++)
		{
			String title = xpath.evaluate("/rss/channel/item[" + i + "]/title", feedDocument);
			String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument);
			String pubDate = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);

			Calendar date = Calendar.getInstance();
			date.setTime(df.parse(pubDate));
			
			feedItems.add(new Tweet(title, date, link));
		}
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