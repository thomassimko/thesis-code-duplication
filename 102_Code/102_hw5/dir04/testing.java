import java.util.List;


public class testing 
{
	
	public static void tests()
	{
		FeedReader test = new readFeed();
		
		test.addSource("http://search.twitter.com/search.rss?q=keen_csc102");
		test.addSource("http://search.twitter.com/search.rss?q=MCRofficial");
		test.addSource("http://search.twitter.com/search.rss?q=bbcEurovision");

		List<RSSItem> tweets = test.retrieveFeedItems();

		for(int i = 0; i < tweets.size(); i++)
		{
			System.out.println(tweets.get(i).getTitle());
			System.out.println("   " + tweets.get(i).strDate());
			System.out.println("   " + tweets.get(i).getLink() + "\n");
		}
	}
	
	public static void main(String [] args)
	{
		tests();
	}
}
