import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class readFeed 
	implements FeedReader
{
	private List<String> sources = new ArrayList<String>();
	private List<String> badSources = new ArrayList<String>();
	private List<String> sort = new ArrayList<String>();
	
	public void addSource(String src) 
	{
		Comparator<String> comp = new alphaSort();
		
		sources.add(src);
		sort.add(src);
		
		Collections.sort(sort, comp);
	}

	public List<String> getSources() 
	{
		return this.sources;
	}
	
	public List<String> getSortSource()
	{
		return this.sort;
	}

	public List<RSSItem> retrieveFeedItems() 
	{
		List<RSSItem> items = new ArrayList<RSSItem>();
		badSources.clear();
		
		for(int i = 0;i < sources.size(); i++)
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(sources.get(i));
				
				XPathFactory xpfactory = XPathFactory.newInstance();
				XPath xpath = xpfactory.newXPath();
				
				String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				int itemCount = Integer.parseInt(countStr);
				
				for(int j = 1; j < itemCount + 1; j++)
				{					
					String titleStr = new String("/rss/channel/item[" + j + "]/title");
					String linkStr = new String("/rss/channel/item[" + j + "]/link");
					String dateStr = new String("/rss/channel/item[" + j + "]/pubDate");
					
					String title = xpath.evaluate(titleStr, feedDocument);
					String link = xpath.evaluate(linkStr, feedDocument);
					String date = xpath.evaluate(dateStr, feedDocument);
					
					DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
					Date d = null;
					d = df.parse(date);
					Calendar c = Calendar.getInstance();
					c.setTime(d);
					
					RSSItemObj element = new RSSItemObj(title, c, link);
					
					items.add(element);
				}
			}
			catch(Exception e)
			{
				badSources.add(sources.get(i));
				//sources.set(i, "Bad Source");
			}
		}
		return items;
	}

	public List<String> getBadSources()
	{
		Comparator<String> comp = new alphaSort();
		
		Collections.sort(badSources, comp);
		
		return badSources;
	}

	public void removeBadSources() 
	{
		for(int i = 0; i < badSources.size(); i++)
		{
			sources.remove(badSources.get(i));
		}
		badSources.clear();
	}
}
