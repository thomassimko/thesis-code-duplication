public class Tweeter
{
	public static void main(String [] args)
	{
		FeedReader reader = new TwitterFeedReader();
		
		new TweeterGUI(reader);
	}
}