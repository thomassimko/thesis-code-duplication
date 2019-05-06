import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Read implements FeedReader
{
	List<RSSItem> feed = new ArrayList<RSSItem>();
	List<String> bad = new ArrayList<String>();
	List<String> sources = new ArrayList<String>();

	@Override
	public void addSource(String src)
	{
		// TODO Auto-generated method stub
		sources.add(src);
	}

	@Override
	public List<String> getSources()
	{
		Collections.sort(sources, new SourcesComparator());
		return sources;
	}

	@Override
	public List<RSSItem> retrieveFeedItems()
	{
		feed.clear();
		bad.clear();
		for (int j = 0; j < sources.size(); j++)
		{
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(sources.get(j));

				XPathFactory xpfactory = XPathFactory.newInstance();
				XPath xpath = xpfactory.newXPath();
				String countStr = xpath.evaluate("count(/rss/channel/item)",
						feedDocument);
				int itemCount = Integer.parseInt(countStr);
				for (int i = 1; i <= itemCount; i++)
				{
					String title = xpath.evaluate("/rss/channel/item[" + i
							+ "]/title", feedDocument);
					String link = xpath.evaluate(
							"/rss/channel/item[" + i + "]/link", feedDocument);
					String date = xpath.evaluate("/rss/channel/item[" + i
							+ "]/pubDate", feedDocument);
					DateFormat format = new SimpleDateFormat(
							"EEE, dd MMM yyyy HH:mm:ss z");
					DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
					Date formatted = format.parse(date);
					String formatted1 = format1.format(formatted);
					Date last = format1.parse(formatted1);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(last);
					RSSItem item = new RSS(title, calendar, link);
					feed.add(item);
				}
			} catch (ParserConfigurationException e)
			{
				System.err.println("Parser Exception");
			} catch (IOException e)
			{
				bad.add(sources.get(j));
			} catch (SAXException e)
			{
				bad.add(sources.get(j));
			} catch (XPathExpressionException e)
			{
				bad.add(sources.get(j));
			} catch (ParseException e)
			{
				bad.add(sources.get(j));
			}
		}
		Collections.sort(feed, new DateComparator());
		return feed;
	}

	@Override
	public List<String> getBadSources()
	{
		Collections.sort(bad, new SourcesComparator());
		return bad;

	}

	@Override
	public void removeBadSources()
	{
		for (String bstring : bad)
		{
			sources.remove(bstring);
		}
	}

}
