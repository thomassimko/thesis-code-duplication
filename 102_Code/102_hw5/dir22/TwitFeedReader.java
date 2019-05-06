import java.util.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
//import java.lang.*;
import java.io.*;
//import javax.swing.text.*;
import org.w3c.dom.Document;
import org.xml.sax.*;
public class TwitFeedReader
  implements FeedReader
{
  private List<String> sourcesList = new ArrayList<String>();
  private List<String> badSources = new ArrayList<String>();
  private Document feedDocument;
  
  public TwitFeedReader()
  {
    
  }
  public void addSource(String src)
  {
    sourcesList.add(src);
  }
  public List<String> getSources()
  {
    return this.sourcesList;
  }
  public List<RSSItem> retrieveFeedItems()
  {
	  List<RSSItem> feedItems = new ArrayList<RSSItem>();
	for(int k = 0; k < sourcesList.size(); k++)
	{	
	  String parseURL = sourcesList.get(k);
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = null;
	    try
	    {
	      builder = factory.newDocumentBuilder();
	    }
	    catch(ParserConfigurationException PCE)
	    {
	      System.out.println("ERROR: Incorrect parse configuration"); 
	      System.exit(-1);
	    }
	    XPath xpath = null;
	    try
	    {
	      this.feedDocument = builder.parse(parseURL);    
	      //counting number of items: 
	      XPathFactory xpfactory = XPathFactory.newInstance();
	      xpath = xpfactory.newXPath();
	    }
	    catch(IOException IOE)
	    {
	      System.out.println("ERROR: Action interrupted by I/O operations.");
	      System.exit(-1);
	    }   
	    catch(SAXException SAXE)
	    {
	      System.out.println("ERROR: Could not parse");
	      System.exit(-1);
	    }
	    int itemCount = 1;
	    try
	    {
	      String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
	      itemCount = Integer.parseInt(countStr);
	      System.out.println("itemCount = " + itemCount);
	    }
	    catch(XPathExpressionException X)
	    {
	      System.out.println("ERROR: Could not recognize XPath Expression");
	      System.exit(-1);
	    }
	   try
	   {
		   
	    for(int i = 1; i<=itemCount; i++)
	    {
	      String title = xpath.evaluate("/rss/channel/item["+i+"]/title", feedDocument);
	      String link = xpath.evaluate("/rss/channel/item["+i+"]/link", feedDocument);
	      String date = xpath.evaluate("/rss/channel/item["+i+"]/pubDate", feedDocument);
	      TwitRSSItem TRI = new TwitRSSItem(title, date, link);
	      
	      if(title.equals(null) || link.equals(null) || date.equals(null) || TRI.getDate().equals(null))
	        //In case the title or link or date was found to be bad
	      {
	        this.badSources.add(link);
	      }
	      else
	      {
	        feedItems.add(TRI);
	      }
	    }
	   } 
	   catch(XPathExpressionException XPE)
	   {
	    System.out.println("ERROR: could not read expression");
	    System.exit(-1);
	   }
	}  
    return feedItems;
  }
  public  List<String> getBadSources()
  {
    return this.badSources;
  }
  public void removeBadSources()
  {
    //go thru list of badsources, find them in the sources list and remove them
    for(int i=0 ; i<badSources.size() ; i++)
    {
      for(int j=0 ; j<sourcesList.size() ; j++)
      {
        if(badSources.get(i).equals(sourcesList.get(j)))
        {
          sourcesList.remove(j);
        }
      }
    }
  }
}
