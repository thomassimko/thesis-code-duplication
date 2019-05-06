import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import java.lang.NullPointerException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Reader
	implements FeedReader
{
	private ArrayList<String> srcList = new ArrayList<String>();
	private ArrayList<RSSItem> rssList = new ArrayList<RSSItem>();
	private ArrayList<String> badsrcList = new ArrayList<String>();

	public void addSource(String src)
	{
		srcList.add(src);
	}

	public List<String> getSources() 
	{
		return this.srcList;
	}

	public List<RSSItem> retrieveFeedItems()
	{
		badsrcList.clear();
		int srcSize = srcList.size();
		for (int i = 0; i < srcSize; i++)
		{
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(srcList.get(i));
				
				XPathFactory xpfactory = XPathFactory.newInstance();
				XPath xpath = xpfactory.newXPath();
				
				String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				int itemCount = Integer.parseInt(countStr);
				for (int j = 1; j < itemCount; j++)
				{
					String title = xpath.evaluate("/rss/channel/item["+ j + "]/title", feedDocument);
					String link = xpath.evaluate("/rss/channel/item["+ j +"]/link", feedDocument);
					String stringDate = xpath.evaluate("/rss/channel/item["+ j +"]/pubDate", feedDocument);
					Calendar date = dateRead(stringDate);
					rssList.add(new RSSObject(title,date,link));
				}
			}
			catch(ParserConfigurationException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("Document not created");
			}
			catch(SAXException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("Error while parsing");
			}
			catch(IOException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("IO Error");
			}
			catch(XPathExpressionException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("Expression can not be evaluated");
			}
			catch(NullPointerException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("Empty list");
			}
			catch(ParseException e)
			{
				badsrcList.add(srcList.get(i));
				System.out.println("Error while parsing date");
			}
		}
		return rssList;
	}

	public List<String> getBadSources()
	{
		return this.badsrcList;
	}
	
	public void removeBadSources()
	{
		srcList.removeAll(badsrcList);
	}

	public static Calendar dateRead(String s)
		throws ParseException
	{
		DateFormat inputDf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		DateFormat outputDf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date d = inputDf.parse(s);
		String last = outputDf.format(d);
		Date lastD = outputDf.parse(last);
		Calendar c = Calendar.getInstance();
		c.setTime(lastD);
		return c;
	}
}
