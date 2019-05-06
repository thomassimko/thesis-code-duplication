import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;


public class Reader implements FeedReader
{
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private Document feedDocument;
	private DocumentBuilder builder = null;
	private int itemCount;
	private XPathFactory xpfactory = XPathFactory.newInstance();
	private XPath xpath = xpfactory.newXPath();
	private String countStr = null;
	private List<String> sources = new LinkedList<String>();
	private List<String> badSources;
	
	public Reader()
	{
		try
		{
			builder = factory.newDocumentBuilder();
		}
		catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		String title = null;
		String link = null;
		String date = null;
		List<RSSItem> iList = new LinkedList<RSSItem>();
		badSources = new LinkedList<String>();
		Calendar c = Calendar.getInstance();
		
		for(String source : sources)
		{
			try
			{
				this.feedDocument = (Document)builder.parse(source);
				this.countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				this.itemCount = Integer.parseInt(countStr);

				for(int j = 1; j <= itemCount; j++)
				{
					title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
					link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
					date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
					SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
					Date d = null;
					d = dateFormat.parse(date);
					c.setTime(d);
					if(title != null && c != null && link != null)
					{
						iList.add(new Item(title, c, link));
					}
					else
					{
						badSources.add(source);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				badSources.add(source);
				continue;
			}
		}
		return iList;
	}

	@Override
	public List<String> getBadSources()
	{
		return badSources;
	}

	@Override
	public void removeBadSources()
	{
		int size = badSources.size();
		
		for(int i = 0; i < size; i++)
		{
			String bad = badSources.get(i);
			if(sources.contains(bad))
			{
				sources.remove(sources.indexOf(bad));
			}
		}
	}

}
