import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Reader implements FeedReader 
{
	ArrayList<String> sourceList = new ArrayList<String>();
	ArrayList<String> badList = new ArrayList<String>();
	
	public void addSource(String src) 
	{
		sourceList.add(src);
		Collections.sort(sourceList, String.CASE_INSENSITIVE_ORDER);
	}

	public List<String> getSources()
	{
		return sourceList;
	}

	public List<RSSinfo> retrieveFeedItems() 
	{
		int m=0;
		List<RSSinfo> feedList = new ArrayList<RSSinfo>();
		
		for(int i=0;i<sourceList.size();i++)
		{
			try
			{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document feedDocument = builder.parse(sourceList.get(i));
			
			XPathFactory xpfactory = XPathFactory.newInstance();
			XPath xpath = xpfactory.newXPath();
			
			String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
			int itemCount = Integer.parseInt(countStr);
			
			
			for(int j=1;j<+itemCount;j++)
			{
				String title = xpath.evaluate("/rss/channel/item["+j+"]/title", feedDocument);
				String link = xpath.evaluate("/rss/channel/item["+j+"]/link", feedDocument);
				
				String date = xpath.evaluate("/rss/channel/item["+j+"]/pubDate", feedDocument);
				DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
				Date d = df.parse(date);
				Calendar c = Calendar.getInstance();
				c.setTime(d);
				
				feedList.add(new RSSinfo(title, c, link));
			}
			}
			catch (Exception e)
			{
				if (!badList.contains(sourceList.get(i)))
					badList.add(sourceList.get(i));
			}
		}
		Collections.sort(feedList, new DateComparator());
		return feedList;
	}

	public List<String> getBadSources()
	{
		return badList;
	}

	public void removeBadSources()
	{
		for(int i=0;i<badList.size();i++)
		{
			for(int j=0;j<sourceList.size();j++)
			{
				if(badList.get(i).equals(sourceList.get(j)))
				{
					sourceList.remove(j);
				}
			}
		}
	}

}
