import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Reader 
		implements FeedReader
{

	List<Document> documents = new ArrayList<Document>();
	List<String> sources = new ArrayList<String>(); 
	List<RSSItem> items = new ArrayList<RSSItem>();
	List<String> badSources = new ArrayList<String>();

	public void addSource(String src) 
	{
		if(!src.equals(""))
		sources.add(src);
	}

	public List<String> getSources() 
	{
		
		Collections.sort(sources, new SourceComparator<String>());
		return sources;
	}

	public List<RSSItem> retrieveFeedItems() 
	{
		items.clear();
		documents.clear();
		badSources.clear();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			for (int i = 0; i < sources.size(); i++) 
			{
				String src = sources.get(i);
				try {
					Document feedDocument = builder.parse(src);
					documents.add(feedDocument);

				} catch (SAXException e) {

				} catch (IOException e) {

					badSources.add(src);
				}
			}
		} catch (ParserConfigurationException e) {
			System.out.println("Failed to create document");
		}
		Document d;
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		int size = documents.size();
		for (int i = 0; i < size; i++) 
		{
			d = documents.get(i);
			String countStr;
			try {
				countStr = xpath.evaluate("count(/rss/channel/item)", d);
				int itemCount = Integer.parseInt(countStr);
				{
					for(int j = 1; j < itemCount; j++)
					{
						String title = xpath.evaluate("/rss/channel/item[" + j + "]/title", d);
						String link = xpath.evaluate("/rss/channel/item[" + j + "]/link", d);
						String date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", d);
						DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
						Date theDate;
						try {
							theDate = df.parse(date);
							items.add(new Item(title, link, theDate));
							Collections.sort(items, new DateComparator());
						} catch (ParseException e) {
							if(!sources.isEmpty())
							badSources.add(sources.get(i));
						}
						
					}
				}
			} catch (XPathExpressionException e) 
			{
				//if(!sources.isEmpty())
				//badSources.add(sources.get(i));
			}
		}
		return items;
	}

	public List<String> getBadSources() 
	{
		Collections.sort(badSources, new SourceComparator<String>());
		return badSources;
	}

	public void removeBadSources() 
	{
		int index = -1;
		for(int x = 0; x < badSources.size(); x++)
		{
			index = sources.indexOf(badSources.get(x));
			if(index >= 0)
			{
				sources.remove(index);
			}
		}
		badSources.clear();
	}

}
