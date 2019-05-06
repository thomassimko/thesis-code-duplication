import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestCases
{
   public static void main(String[] args)
   {
      FeedReader test = new Reader();
      test.addSource("http://search.twitter.com/search.rss?q=from:keen_csc102");
      test.addSource("http://search.twitter.com/search.rss?q=from:Angels");
      test.addSource("http://search.twitter.com/search.rss?q=from:jcrclarksonesq");
      test.addSource("http://search.twitter.com/search.rss?q=from:MrJamesMay");
      test.addSource("poop");
      test.addSource("poooooop");
      
      test.retrieveFeedItems();
      test.retrieveFeedItems();
      List<String> badList = new ArrayList<String>();
      badList = test.getBadSources();
      for(int i=0;i<badList.size();i++)
      {
    	  System.out.println(badList.get(i));
      }
      
      SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      /*for(RSSItem item : test.retrieveFeedItems())
      {
         System.out.println(item.getTitle());
         System.out.println("   " + df.format(item.getDate().getTime()));
         System.out.println("   " + item.getLink() + "\n");
      }*/
   }
}