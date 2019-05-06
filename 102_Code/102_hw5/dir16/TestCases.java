import java.util.*;

public class TestCases
{
	public static void testSources(FeedReader feed)
	{
		feed.addSource("http://search.twitter.com/search.rss?q=from:allkpop");
		feed.addSource("http://search.twitter.com/search.rss?q=mirai%20nikki");
		feed.addSource("http://search.twitter.com/search.rss?q=call%20me%20maybe");

		System.out.println("SOURCES:");
		for(String src : feed.getSources())
		{
			System.out.println(src);
		}
	}

	public static void testRetrieveFeedItems(FeedReader feed)
	{
		List<RSSItem> items = feed.retrieveFeedItems();

		System.out.println("FEED ITEMS:");
		for(RSSItem item : items)
		{
			System.out.println(String.format("%1$-20.20s %2$2tm/%<2td/%<tY %3$-30.30s",
				item.getTitle(), item.getDate(), item.getLink()));
		}
	}

	public static void testRemoveBadSources(FeedReader feed)
	{
		feed.addSource("Bad Source");
		feed.addSource("http://search.twitter.com/swearch.rss?q=SHINee");

		System.out.println("SOURCES:");
		for(String src : feed.getSources())
		{
			System.out.println(src);
		}

		System.out.println();

		feed.retrieveFeedItems();

		System.out.println("BAD SOURCES:");
		for(String src : feed.getBadSources())
		{
			System.out.println(src);
		}

		System.out.println();

		feed.removeBadSources();

		System.out.println("SOURCES:");
		for(String src : feed.getSources())
		{
			System.out.println(src);
		}
	}

	public static void main(String [] args)
	{
		FeedReader feed = new TwitterFeedReader();

		testSources(feed);

		System.out.println();

		testRetrieveFeedItems(feed);

		System.out.println();

		testRemoveBadSources(feed);
	}
}