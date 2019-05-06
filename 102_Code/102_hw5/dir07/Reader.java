import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;


public class Reader 
	implements FeedReader
{
	private List<String> sourcesList;
	private List<String> badSourcesList;
	
	public Reader()
	{
		sourcesList = new ArrayList<String>();
		badSourcesList = new ArrayList<String>();		
	}
	

	@Override
	public void addSource(String src)
	{
		if(src.isEmpty())
		{
			return;
		}
		sourcesList.add(src);
	}

	@Override
	public List<String> getSources()
	{
		return sourcesList;
	}

	@Override
	public List<RSSItem> retrieveFeedItems()
	{
		List<RSSItem> itemsList = new ArrayList<RSSItem>();
		badSourcesList = new ArrayList<String>();
		
		for(String src : sourcesList)
		{	
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(src);
			
				XPathFactory xpfactory = XPathFactory.newInstance(); 
				XPath xpath = xpfactory.newXPath();
				String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument); 
				int itemCount = Integer.parseInt(countStr);
			
				for(int i=1; i<=itemCount; i++)
				{
					String title = xpath.evaluate("/rss/channel/item["+i+"]/title", feedDocument); 
					String sourceDate = xpath.evaluate("/rss/channel/item["+i+"]/pubDate", feedDocument);
					String link = xpath.evaluate("/rss/channel/item["+i+"]/link", feedDocument); 
					Calendar calendar = null;
					try
					{
						DateFormat df = new SimpleDateFormat("EEE, dd MMMMM yyyy HH:mm:ss zzz"); 
						Date date = df.parse(sourceDate);
						calendar = Calendar.getInstance();
						calendar.setTime(date);
					}
					catch(ParseException e)
					{
						System.err.println("Invalid Date at " + i);
					}

					RSSItem item = new Item(title, calendar, link);
					itemsList.add(item);
				}
			}
			catch(Exception e)
			{
				badSourcesList.add(src);
			}
		}
		return itemsList;
	}

	@Override
	public List<String> getBadSources()
	{
		return badSourcesList;
	}

	@Override
	public void removeBadSources()
	{
		for(String src : badSourcesList)
		{
			sourcesList.remove(src);
		}
		badSourcesList = new ArrayList<String>();
	}

}
