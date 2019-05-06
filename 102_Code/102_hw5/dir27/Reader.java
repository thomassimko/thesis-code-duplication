import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException; 
import org.w3c.dom.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Reader
	implements FeedReader
{
	List<String> srcs = new ArrayList<String>();
	List<String> bads = new ArrayList<String>();
	
	 /**
      Adds a new source to the list of sources from which feeds are
      retrieved.
      @param: src The URL of the source.
   */
   public void addSource(String src)
	{
		this.srcs.add("http://search.twitter.com/search.rss?q=from:"+src);
	}

   /**
      Returns the list of sources that this reader is working with.
   */
   public List<String> getSources()
	{
		return this.srcs;
	}

   /**
      Returns a list of feed items pulled from the current list of sources.
   */
   public List<RSSItem> retrieveFeedItems()
	{
		List<RSSItem> rss = new ArrayList<RSSItem>();
		int size = srcs.size();
		int i = 0;
		List<RSSItem> temprss;
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document feedDocument;
		XPathFactory xpfactory;
		XPath xpath;
		String countStr;
		int itemCount;
		while (i < size)
		{
			try
			{
				factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
				feedDocument = builder.parse(srcs.get(i));
					
				xpfactory = XPathFactory.newInstance();
				xpath = xpfactory.newXPath();
				countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				itemCount = Integer.parseInt(countStr);
				for (int j=1; j<=itemCount; j++)
				{
					String title = xpath.evaluate("/rss/channel/item["+j+"]/title", feedDocument);
					String link = xpath.evaluate("/rss/channel/item["+j+"]/link", feedDocument);
					String date = xpath.evaluate("/rss/channel/item["+j+"]/pubDate", feedDocument);
					DateFormat d = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
					Date temp = d.parse(date);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(temp);
					RSSInstance item = new RSSInstance(title, calendar, link);
					rss.add(item);
				}
				i++;
			}
			catch (ParseException a)
			{
				System.err.println("Parse Error");
				bads.add(srcs.get(i));
				i++;
			}
			catch (ParserConfigurationException b)
			{
				System.err.println("ParserConfig Error");
				bads.add(srcs.get(i));
				i++;
			}
			catch (SAXException c)
			{
				System.err.println("SAX Error");
				bads.add(srcs.get(i));
				i++;
			}
			catch (XPathExpressionException d)
			{
				System.err.println("XPath Error");
				bads.add(srcs.get(i));
				i++;
			}
			catch (IOException e)
			{
				System.err.println("IO Error" + e.getMessage());
				bads.add(srcs.get(i));
				i++;
			}
		}
		return rss;
	}

   /**
      Returns a list of those sources found to be bad during the
      last retrieval of feed items.
   */
   public List<String> getBadSources()
	{
		return this.bads;
	}

   /**
      Removes the currently identified set of bad sources from the
      full set of sources.
   */
   public void removeBadSources()
	{
		srcs.removeAll(bads);
		this.bads.clear();
	}
}
