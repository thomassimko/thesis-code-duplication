import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.SAXException;
public class TwitterReader
   implements FeedReader
{
   private List<RSSItem> itemList;
   private List<String> sourceList;
   private List<String> badSourceList;
   public TwitterReader()
   {
   	  this.itemList = new ArrayList<RSSItem>();
   	  this.sourceList = new ArrayList<String>();
   	  this.badSourceList = new ArrayList<String>();
   }
   public void addSource(String src)
   {
	  boolean flag = true;
	  for(String s : sourceList)
	  {
		  if(s.equals(src))
		  {
		     flag = false;
		  }
	  }
	  if(flag)
	  {
		 this.sourceList.add(0, src);					   
	  }	
	  Collections.sort(this.sourceList, new AlphaComparator());
   }   
   public List<String> getSources()
   {
      return this.sourceList;
   }
   public List<RSSItem> retrieveFeedItems()
   {
      itemList = new ArrayList<RSSItem>();	
      badSourceList = new ArrayList<String>();
      List<RSSItem> tempItemList;
      DocumentBuilderFactory factory;
      DocumentBuilder builder;
      org.w3c.dom.Document feedDocument;
      RSSItem newItem;
      String countStr;
      String title;
      String link;
      String date;
      Calendar cal;
      int itemCount = 0; 
      for(String s : sourceList)
      {
         tempItemList = new ArrayList<RSSItem>();
         factory = DocumentBuilderFactory.newInstance();
         try 
         {				
            builder = factory.newDocumentBuilder();				
            feedDocument = builder.parse(s);				         
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath xpath = xpfactory.newXPath();		  
            countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            itemCount = Integer.parseInt(countStr);
            for(int i = 1; i <= itemCount; i++)
            {		
            	title = xpath.evaluate("/rss/channel/item[" + i + "]/title", feedDocument);	
            	link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument);	
            	date = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);
            	cal = formatDate(date);
            	newItem = new Item(title, link, cal);		  			       					
            	tempItemList.add(tempItemList.size(), newItem); 		 		       
            }	
            Collections.sort(tempItemList, new RSSItemComparator());
            int count = itemList.size();
            for(RSSItem item : tempItemList)
            {
            	itemList.add(count, item);
            	count++;
            }	  								
         } 
         catch (XPathExpressionException e) 
         {
        	 badSourceList.add(0, s); 		       
         }		
         catch (ParserConfigurationException e) 
         {
        	 badSourceList.add(0, s); 		       
         }	
         catch (SAXException e) 
         {
        	 badSourceList.add(0, s); 		       
         }	
         catch (IOException e) 
         {
        	 badSourceList.add(0, s); 		       
         }
         catch(IllegalArgumentException e)
         {
        	 badSourceList.add(0, s); 
         }
      }
      return itemList;
   }
		
   private Calendar formatDate(String date) 
		   throws XPathExpressionException
		   {
	   Date d = null;
	   DateFormat df = null;
	   Calendar cal = null;
	   try
	   {
		   df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
		   try 
		   {
			   d = df.parse(date);
		   }
		   catch (ParseException e) 
		   {
			   throw new XPathExpressionException(e);
		   }
		   cal = Calendar.getInstance();
		   cal.setTime(d);
		   return cal;
	   } 
	   catch(XPathExpressionException e) 
		{
			throw new XPathExpressionException(e);
		}
	}
	public List<String> getBadSources()
	{
		Collections.sort(badSourceList, new AlphaComparator());
		return this.badSourceList;
	}
	public void removeBadSources()
	{  
		int badSourceSize = badSourceList.size();
		int sourceSize = sourceList.size();
		boolean flag;
		for(int j = 0; j < sourceSize; j++)
		{
			flag = true;
			for(int i = 0; i < badSourceSize && flag; i++)
			{
				if(badSourceList.get(i).equals(sourceList.get(j)))
				{
					sourceList.remove(j); 
		   			j = j - 1;
		   			sourceSize--;
		   			flag = false;
				}
			}
		}
		this.badSourceList = new ArrayList<String>();
	}
}    

