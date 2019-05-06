import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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



public class FeedReaderClass
implements FeedReader
{
	private List<String> goodList;
	private List<String> badList;
	private List<RSSItem> RSSList;
	
	public FeedReaderClass()
	{
		goodList = new ArrayList<String>();
		badList = new ArrayList<String>();
		RSSList = new ArrayList<RSSItem>();
	}
	
	public void addSource(String src)
	{
		goodList.add(src);
	}
	public List<String> getGoodList()
	{
		return goodList;
	}

	public List<String> getBadSources()
	{
		return badList;
	}

	public List<String> getSources()
	{
		return goodList;
	}
	
	public void removeBadSources()
	{
		int i = 0;
		int j =0;
		
		for(i=0; i<goodList.size(); i++)
		{
			for(j=0; j<badList.size(); j++)
			{
				if(goodList.get(i).equals(badList.get(j)))
				{
					goodList.remove(i);
				}
			}
		}
	}
	
	public List<RSSItem> retrieveFeedItems()
	{
		Document feedDocument = null;
		String src, link = null, title = null, date = null, countStr;;
		XPathFactory xpfactory = null;
		XPath xpath = null;
		int i, itemCount = 0;
		badList.clear();
			
		for(i=0; i < goodList.size(); i++)
		{
			src = goodList.get(i); 
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder;
				builder = factory.newDocumentBuilder();
				feedDocument = builder.parse(src);
				xpfactory = XPathFactory.newInstance();
				xpath= xpfactory.newXPath();
				countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				itemCount = Integer.parseInt(countStr);
			
				for(int j = 1; j <= itemCount; j++)
				{
					Date d1 = null;
					Calendar c =null;
					try
					{
						date =  xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
						link =  xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
						title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);

						SimpleDateFormat d = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
						SimpleDateFormat k = new SimpleDateFormat("MM/dd/yyyy HH:mm");

						d1 = d.parse(date);
						String date2 = k.format(d1); 
						c= GregorianCalendar.getInstance();
						c.setTime(d1);
						RSSItemClass rss = new RSSItemClass(c, link, title);
						RSSList.add(rss);
					} 
					catch (ParseException e)
					{
						badList.add(src);
					}
				}
			}
			catch (ParserConfigurationException e1)
			{
				badList.add(src);
			}
			catch (IOException e)
			{
				badList.add(src);
			}
			catch (SAXException e)
			{
				badList.add(src);
			}
			catch (XPathExpressionException e2)
			{
				badList.add(src);
			}
		}
		return RSSList;
	}

}
