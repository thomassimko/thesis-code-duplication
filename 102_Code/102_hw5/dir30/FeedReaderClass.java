import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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


public class FeedReaderClass implements FeedReader 
{
	private List<String> srcList = new ArrayList<String>();
	private List<Document> documentList = new ArrayList<Document>();
	private List<String> badSrcList = new ArrayList<String>();
	private List<Document> badDocumentList = new ArrayList<Document>();
	
	public FeedReaderClass()
	{

	}
	
	@Override
	public void addSource(String src) 
	{
		srcList.add(src);
	}

	@Override
	public List<String> getSources() 
	{
		int documentListSize = documentList.size();
		
		srcList.clear();
		
		for(int i = 0; i < documentListSize; i++)
		{
			String src = documentList.get(i).getDocumentURI();
			srcList.add(src);
		}
		
		return srcList;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() 
	{		
		badDocumentList.clear();
		
		parseSources();
		
		int numberOfFeeds = documentList.size();
		Document feedDocument = null;
		List<RSSItem> itemList = new ArrayList<RSSItem>();
		
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		
		for(int i = 0; i < numberOfFeeds; i++)
		{
			feedDocument = documentList.get(i);
			
			String countStr = null;
			try 
			{
				countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				
				int itemCount = Integer.parseInt(countStr);
				
				for(int j = 1; j <= itemCount; j++)
				{
					String title = null;
					String link = null;
					String d = null;
					try 
					{
						title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
						link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
						d = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
						
						Calendar c = Calendar.getInstance();
						Date date = null;
						
						DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
						try 
						{
							date = df.parse(d);
							
							c.setTime(date);
							
							RSSItem item = new RSSItemClass(title, c, link);
							
							itemList.add(item);
						} 
						catch (ParseException e) 
						{
							badDocumentList.add(feedDocument);
							break;
						}

					} 
					catch (XPathExpressionException e1) 
					{
						badDocumentList.add(feedDocument);
						break;
					}
					
				}
			} 
			catch (XPathExpressionException e1) 
			{
				badDocumentList.add(feedDocument);
			}

		}
		return itemList;
	}

	private void parseSources() 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document feedDocument = null;
		
		try 
		{
			builder = factory.newDocumentBuilder();
		} 
		catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			documentList.clear();
			
			for(int i = 0; i < srcList.size(); i++)
			{
				feedDocument = builder.parse(srcList.get(i));
				documentList.add(feedDocument);
			}
		} 
		catch (SAXException e) 
		{
			badDocumentList.add(feedDocument);
		} 
		catch (IOException e) 
		{
			badDocumentList.add(feedDocument);
		}
		
	}

	@Override
	public List<String> getBadSources() 
	{
		int badDocumentListSize = badDocumentList.size();
		
		badSrcList.clear();
		
		for(int i = 0; i < badDocumentListSize; i++)
		{
			String badSrc = badDocumentList.get(i).getDocumentURI();
			badSrcList.add(badSrc);
		}
		
		return badSrcList;
	}

	@Override
	public void removeBadSources() 
	{
		int badDocumentListSize = badDocumentList.size();
		
		for(int i = 0; i < badDocumentListSize; i++)
		{
			Document badDoc = badDocumentList.get(i);
			documentList.remove(badDoc);
		}
		
		badDocumentList.clear();
	}

}
