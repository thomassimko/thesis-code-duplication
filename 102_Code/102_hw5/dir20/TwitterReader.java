import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;


public class TwitterReader
   implements FeedReader
{
   
	private ArrayList<RSSItem> rssItemList = new ArrayList<RSSItem>();
	private ArrayList<String> badSourceList = new ArrayList<String>();
	private ArrayList<String> sourceList = new ArrayList<String>();
	
	public TwitterReader(ArrayList<String> sourceList)
	{
	   this.sourceList = sourceList;
	}
 
   public void addSource(String src)
   {
     sourceList.add(src);   // double check if need index
   }

   
   public List<String> getSources()
   {  
      return sourceList;
   }

   
   public List<RSSItem> retrieveFeedItems()
   {
	   int j = 0;
	
	   try {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
			
			for(j = 0; j < sourceList.size(); j++)
			{
            Document feedDocument = builder.parse(sourceList.get(j));
     
	         XPathFactory xpfactory = XPathFactory.newInstance();
			   XPath xpath = xpfactory.newXPath();
			
		   	String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
			   int itemCount = Integer.parseInt(countStr);
			
			   for(int i = 1; i <= itemCount; i++)
		   	{
			    String title = xpath.evaluate("/rss/channel/item[" + i + "]/title", feedDocument);
			   	String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument);
			   	String dateString = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);
				
			   	DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
					DateFormat ndf = new SimpleDateFormat("MM/dd/yyy HH:mm");
					
               Date date = df.parse(dateString);
					String newDateString = ndf.format(date);
					Date date2 = ndf.parse(newDateString);
					
			   	Calendar cal = Calendar.getInstance();
				   cal.setTime(date2);

				   TwitterItem twitItem = new TwitterItem(title, cal, link);
				
				   rssItemList.add(twitItem);  // Should I add index? <--be sure to test
			   }
	      }
	   }
    	catch (ParserConfigurationException pc)
    	{
	     System.err.println("parser config error."); // when exception is thrown should add item to a badSource list.
	     badSourceList.add(sourceList.get(j));
	   }
	   catch (SAXException sax)
	   {
	     System.err.println("sax exception....");
		  badSourceList.add(sourceList.get(j));
	   }  
		catch (IOException i)
		{
		  System.err.println("IO exception.");
		  badSourceList.add(sourceList.get(j));
		}
		catch (XPathExpressionException xp)
		{
		  System.err.println("x path Expression exception.");
		  badSourceList.add(sourceList.get(j));
		}
		catch (ParseException pe)
		{
		  System.err.println(" parse date error.");
		  badSourceList.add(sourceList.get(j));
		}
      
      return rssItemList;
   }

   
   public List<String> getBadSources()
   {  
      return badSourceList;
   }

   
   public void removeBadSources()
   {
	
	   rssItemList.removeAll(badSourceList);
   
   }
}