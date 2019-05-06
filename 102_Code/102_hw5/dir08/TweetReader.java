import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class TweetReader
   implements FeedReader
{
   private List<String> sourceList = new ArrayList<String>();
   private List<String> badList = new ArrayList<String>();
   
   public TweetReader()
   {}

   public void addSource(String src)
   {
      sourceList.add(src);
   }

   public List<String> getSources()
   {
      Collections.sort(sourceList);
      
      return sourceList;
   }

   @SuppressWarnings("unchecked")
   public List<RSSItem> retrieveFeedItems()
   {
      List<RSSItem> rssList = new ArrayList<RSSItem>();
      badList.clear();
      
      for (String src : sourceList)
      {
         try
         {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document feedDocument = builder.parse(src);
         
            Helpers.addRSSItems(rssList, feedDocument);
         }
         catch (Exception e)
         {
            badList.add(src);
         }
      }
      
      Collections.sort(rssList, new RSSComparator());
      
      return rssList;
   }

   public List<String> getBadSources()
   {
      return badList;
   }

   public void removeBadSources()
   {
      sourceList.removeAll(badList);
      badList.clear();
   }
}
